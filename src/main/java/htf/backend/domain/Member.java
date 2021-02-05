package htf.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Member { 
	private @Id @GeneratedValue Long mem_key; 
	private String mem_id;
	private String mem_pw;
	private String mem_rank;
	private @ManyToOne Admin ad_id;
} 
