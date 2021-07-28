package com.xworkz.optional.rogi.dao;

import java.util.Collection;
import java.util.Optional;

import com.xworkz.optional.rogi.dto.RogiDTO;

public interface RogiDAO {
    boolean save(RogiDTO dto);
	Optional<RogiDTO> findOne(RogiSearch search);
	Optional<Integer> totalSize();
	Collection<RogiDTO> findAll();
	Collection<RogiDTO> findAll(RogiSearch search);
	Optional<RogiDTO> findByMaxAge();
	Optional<RogiDTO> findByMinAge();

}
