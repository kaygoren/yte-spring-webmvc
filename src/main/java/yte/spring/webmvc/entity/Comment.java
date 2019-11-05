package yte.spring.webmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	private Long id;
	private Long postId;
	private String name;
	private String email;
	private String body;
}
