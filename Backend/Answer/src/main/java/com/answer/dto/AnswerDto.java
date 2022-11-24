package com.answer.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerDto {

	private String answer;
	private Integer questionId;
	private Integer userId;

}
