package htf.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Admin { 
	private @Id @Column(name="ad_id") String adId; 
	private @Column(name="ad_pw") String adPw;
	private String kakaoToken;
} 
 