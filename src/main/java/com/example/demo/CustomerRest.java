package com.example.demo;

import java.security.cert.X509Certificate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRest {

	@GetMapping("/api/cert")
	public String getCertId (HttpServletRequest request) {
		
		X509Certificate[] certs = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
		X509Certificate userCert = certs [0];
		String serialNumber = userCert.getSerialNumber().toString();
		System.out.println("cert subject name: " + userCert.getSubjectDN().getName()); 
		
		return serialNumber;
	}
	
}
