import java.io.*;
	import java.net.*;
	
	public class Sender{
		public static void main(String [] args)throws 				Exception{
			System.out.println("Server Started");
			System.out.println("Waiting for client.....");
			ServerSocket server=null;
			Socket soc=null;
			PrintWriter pws=null;	 
			while(true){
				String lines;
				server = new ServerSocket(1234);
				soc=server.accept();
				BufferedReader brs = new 									BufferedReader(new 									InputStreamReader(soc.getInputStream()));
				String msgs=brs.readLine();
				System.out.println("c>>>:"+msgs);
				if(msgs.equals("bye")){
					System.out.println("----------");
					break;
				}
				System.out.print("s>>>:");
				BufferedReader brs1=new 					BufferedReader(new InputStreamReader(System.in));
				lines=brs1.readLine();
				pws=new 											PrintWriter(soc.getOutputStream(),true);
				pws.println(lines);
				soc.close();
				server.close();
				pws.close();			
			}
		}
	}
