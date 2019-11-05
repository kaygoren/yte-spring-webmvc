package yte.spring.webmvc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import yte.spring.webmvc.validators.TcKimlikNo;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User {
	@NotBlank(message = "Ad boş olamaz!")
	private String name;
	@NotBlank(message = "Soyad boş olamaz")
	private String surname;

	@Max(value = 100,message = "Yaş 100'den büyük olamaz")
	@Min(value = 12,message = "Yaş 12'den küçük olmaz")
	private Long age;
	@NotBlank(message = "E-mail boş olamaz")
	@Email
	private String email;
	@TcKimlikNo
	private String tcKimlikNo;
	@PastOrPresent
	private LocalDateTime localDateTime;
	@Size(max = 250)
	private String location;
	@NotBlank(message = "Kullanıcı adı boş olamaz!")
	private String userName;

	@AssertTrue
	public boolean isUserNameValid() {
		return !userName.equals("admin");
	}
}
