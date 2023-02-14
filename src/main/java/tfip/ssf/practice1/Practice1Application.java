package tfip.ssf.practice1;

import java.io.File;
import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice1Application.class, args);
	}

	//@Override
	public void run(String[] args){
		SpringApplication app= new SpringApplication(Practice1Application.class);
		String port = "3000";
		ApplicationArguments cliOpts= new DefaultApplicationArguments(args);
		if (cliOpts.containsOption("port")){
			port= cliOpts.getOptionValues("port").get(0); // get the first value
		}	
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		System.out.printf("Application started on port %d\n",port);
		app.run(args);

		// if (args.containsOption("dataDir")){
		// 	final String dataDir = args.getOptionValues("dataDir").get(0);
		// 	File fileDir = new File(dataDir);
		// 	if (!fileDir.exists()) {
		// 		fileDir.mkdir();
		// 		System.out.println("***" + fileDir.getAbsolutePath());
		// 		System.out.println("***" + fileDir.getPath());
		// 		System.out.println("***" + fileDir.getParent());
		// 	} else {
		// 		System.out.println(fileDir.getAbsolutePath());
		// 	}
		// }
	}

}
