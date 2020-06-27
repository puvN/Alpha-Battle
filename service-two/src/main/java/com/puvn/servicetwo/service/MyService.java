package com.puvn.servicetwo.service;

import com.puvn.servicetwo.model.Stat;
import com.puvn.servicetwo.model.UserAnalytic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
@Service
public interface MyService {

	List<UserAnalytic> getAllUsersAnalytic();

	UserAnalytic getUserAnalytic(String userId);

	Stat getUserStats(UserAnalytic userAnalytic);

}
