package htf.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Member { 
	private @Id Long mem_key; 
	private String mem_id;
	private String mem_pw;
	private String mem_rank;
//	private Admin ad_id;
} 
