package demo.additionaltechniques;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@ConfigurationProperties(prefix="contact")
public class MyBean2b {

	private String tel;
	private String email;
	private String web;
	
	@Override
	public String toString() {
		return String.format("tel: %s, email: %s, web: %s", tel, email, web );
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
}