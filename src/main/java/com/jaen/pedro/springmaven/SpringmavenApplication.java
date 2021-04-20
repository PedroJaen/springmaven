package com.jaen.pedro.springmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmavenApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringmavenApplication.class, args);

		Scanner sc = new Scanner(System.in);

		ProcessBuilder pb = new ProcessBuilder();
		String adress = "D:\\Documents\\workspace\\flujos\\target\\classes";
		String app = "com.jaen.pedro.flujos.InvierteCadena";
		pb.redirectInput(ProcessBuilder.Redirect.PIPE);
		pb.redirectOutput(ProcessBuilder.Redirect.PIPE);
		pb.command("java", "-cp", adress, app);

		String frase = "";
		do {
			frase = sc.nextLine();

			if(frase.equals("fin")){
				System.out.println("Adios");
			}else{
				try {
					Process p=pb.start();

					BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
					bw.write(frase+System.getProperty("line.separator"));
					bw.flush();

					BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
					String resultado=br.readLine();
					System.out.println(resultado);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (!frase.equals("fin"));
	}

}
