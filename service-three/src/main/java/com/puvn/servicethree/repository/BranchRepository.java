package com.puvn.servicethree.repository;

import com.puvn.servicethree.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 21.06.2020.
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
