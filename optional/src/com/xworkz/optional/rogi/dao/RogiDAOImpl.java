package com.xworkz.optional.rogi.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;

import com.xworkz.optional.rogi.dto.RogiDTO;

public class RogiDAOImpl implements RogiDAO{

	private Collection<RogiDTO> collection = new ArrayList<RogiDTO>();

	
	@Override
	public boolean save(RogiDTO dto) {
		boolean added=collection.add(dto);
		System.out.println(dto);
		System.out.println("dto was added:"+added);
		return added;
	}
	@Override
	public Optional<RogiDTO> findOne(RogiSearch search) {
		Iterator<RogiDTO> iterator=this.collection.iterator();
		Optional<RogiDTO> optional=Optional.empty();
		while (iterator.hasNext()) {
			RogiDTO rogiDTO =  iterator.next();
			if(search.huduku(rogiDTO))
			{
				optional=Optional.of(rogiDTO);
			}
			
		}
		return optional;
	}
	@Override
	public Optional<Integer> totalSize() {
		Optional<Integer> optional=Optional.empty();
         int total=collection.size();
		System.out.println("total size:"+total);
		optional=Optional.of(total);
		return optional;
	}
	@Override
	public Collection<RogiDTO> findAll() {
		
		return this.collection;
	}
	@Override
	public Collection<RogiDTO> findAll(RogiSearch search) {
		Collection<RogiDTO> value = new ArrayList<RogiDTO>();
		this.collection.forEach(t -> {
			if (search.huduku(t)) {
				value.add(t);
			}
		});

		return value;
	}
	@Override
	public Optional<RogiDTO> findByMaxAge() {
		Optional<RogiDTO> opt=Optional.empty();
		opt=Optional.of(Collections.max(collection));
		return opt;
	}
	@Override
	public Optional<RogiDTO> findByMinAge() {
		Optional<RogiDTO> opt=Optional.empty();
		opt=Optional.of(Collections.min(collection));
		return opt;
	}
}
