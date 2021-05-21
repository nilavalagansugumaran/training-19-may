package demo.additionaltechniques;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@ConfigurationProperties(prefix="server")
public class MyBean4 {

	private String address;
	private String port;

	@Override
	public String toString() {
		return String.format("server.address: %s, server.port: %s", address, port);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}