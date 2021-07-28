package com.xworkz.optional.rogi;

import java.util.Collection;
import java.util.Optional;

import com.xworkz.optional.rogi.dao.RogiDAO;
import com.xworkz.optional.rogi.dao.RogiDAOImpl;
import com.xworkz.optional.rogi.dto.RogiDTO;

public class RogiTester {

	public static void main(String[] args) {
		RogiDTO dto1 = new RogiDTO(1, "Ranjitha", 24, "Headache", true);
		RogiDTO dto2 = new RogiDTO(2, "Harshitha", 22, "Eating", true);
		RogiDTO dto3 = new RogiDTO(4, "Sunitha", 24, "Fever", true);
		RogiDTO dto4 = new RogiDTO(5, "Pavitra", 23, "Sleep", true);
		RogiDTO dto5 = new RogiDTO(6, "Vishnavi", 23, "Cough", true);

		// Collection<RogiDTO> collection = Arrays.asList(dto1, dto2, dto3, dto4, dto5);
		// collection.forEach((dto) -> System.out.println(dto));

		RogiDAO dao = new RogiDAOImpl();
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto4);
		dao.save(dto5);

		Optional<RogiDTO> temp = dao.findOne((r) -> r.getName().equals("Ranjitha"));
		boolean v = temp.isPresent();
		System.out.println("present:" + v);
		if (temp.isPresent()) {

			RogiDTO dto = temp.get();
			System.out.println("found:" + dto);
		} else {
			System.out.println("dto not found");
		}

		Optional<Integer> opt = dao.totalSize();
		if (opt.isPresent()) {
			Integer dt = opt.get();

			System.out.println(dt);
		}

		Collection<RogiDTO> all = dao.findAll();
		for (RogiDTO rogiDTO : all) {
			System.out.println("find all:"+rogiDTO);

		}
		Collection<RogiDTO> findAll = dao.findAll((w) -> w.getAge() > 22);
		for (RogiDTO rogiDTO : findAll) {
			System.out.println("find all:"+rogiDTO);

		}
		Optional<RogiDTO> age = dao.findByMaxAge();
		if (age.isPresent()) {
			RogiDTO ag = age.get();
			System.out.println("max age:" + ag);
		}
		Optional<RogiDTO> min = dao.findByMinAge();
		if (min.isPresent()) {
			RogiDTO value = min.get();
			System.out.println("min age:" + value);
		}

	}

}
