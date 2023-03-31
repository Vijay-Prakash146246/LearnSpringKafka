package com.vijay;

import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class FileUploadApplication implements CommandLineRunner
public class FileUploadApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(FileUploadApplication.class, args);
	}
//@Resource
//FilesStorageService storageService;
//
//	public static void main(String[] args) {
//		SpringApplication.run(FileUploadApplication.class, args);
//	}
//
//	@Override
//	public void run(String... arg) throws Exception {
//		storageService.deleteAll();
//		storageService.init();
//	}

}
