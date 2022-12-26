package com.question.Dto;

import java.util.List;

import com.question.entity.Question;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

	private String userName;

	private List<Question> questions;
}
