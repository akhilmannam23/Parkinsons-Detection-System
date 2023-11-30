package com.it.health.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POC_MEDICAL_HISTORY_QUESTIONS")
public class MedicalHistoryQuestionsEntity {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "question")
	private String question;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
