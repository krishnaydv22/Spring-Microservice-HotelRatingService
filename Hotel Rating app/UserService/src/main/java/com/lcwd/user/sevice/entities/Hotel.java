package com.lcwd.user.sevice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {
	
	private String id;
	private String name;
	private String location;
	private String about;

}
