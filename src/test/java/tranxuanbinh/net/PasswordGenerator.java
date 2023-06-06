package tranxuanbinh.net;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPString ="123456"; 
		String encodedPassword = encoder.encode(rawPString);
		
		System.out.println(encodedPassword);
	}

}
