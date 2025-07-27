package com.rating.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		
		String uid = UUID.randomUUID().toString();
		
		rating.setRatingId(uid);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		
		return ratingRepository.findAll();
	}


	@Override
	public List<Rating> getRatingByuserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByhotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
