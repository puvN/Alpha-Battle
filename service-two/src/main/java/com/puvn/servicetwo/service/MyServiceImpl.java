package com.puvn.servicetwo.service;

import com.puvn.servicetwo.kafka.Consumer;
import com.puvn.servicetwo.model.Payment;
import com.puvn.servicetwo.model.SumData;
import com.puvn.servicetwo.model.UserAnalytic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
@Service
public class MyServiceImpl implements MyService {

	private final Consumer consumer;

	@Autowired
	public MyServiceImpl(Consumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public List<UserAnalytic> getAllUsersAnalytic() {
		var payments = this.consumer.getPayments();
		Map<String, List<Payment>> paymentsByUser = payments.values().stream()
				.collect(Collectors.groupingBy(Payment::getUserId));
		final List<UserAnalytic> result = new ArrayList<>(paymentsByUser.size());
		paymentsByUser.forEach((userId, userPayments) -> {
			var userAnalytic = new UserAnalytic();
			userAnalytic.setUserId(userId);
			userAnalytic.setTotalSum(userPayments.stream().mapToDouble(Payment::getAmount).sum());
			Map<Integer, SumData> analyticInfos = new HashMap<>();
			Map<Integer, List<Payment>> paymentsByCategory = userPayments.stream()
					.collect(Collectors.groupingBy(Payment::getCategoryId));
			paymentsByCategory.forEach((categoryId, paymentsByCategoryValues) -> {
				double sum = 0;
				double min = Double.MAX_VALUE;
				double max = Double.MIN_VALUE;
				for (Payment payment: paymentsByCategoryValues) {
					sum += payment.getAmount();
					if (payment.getAmount() < min) {
						min = payment.getAmount();
					}
					if (payment.getAmount() > max) {
						max = payment.getAmount();
					}
				}
				SumData sumData = new SumData(min, max, sum);
				analyticInfos.put(categoryId, sumData);
			});
			userAnalytic.setAnalyticInfo(analyticInfos);
			result.add(userAnalytic);
		});
		return result;
	}

	@Override
	public UserAnalytic getUserAnalytic(String userId) {
		if (userId == null) {
			return null;
		}
		var analytics = this.getAllUsersAnalytic();
		var userAnalytic = analytics.stream().filter(u -> u.getUserId().equals(userId))
				.findFirst();
		return userAnalytic.orElse(null);
	}

}
