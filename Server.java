import java.io.*;
	import java.net.*;
	public class Receiver{
		public static void main(String [] args){//throws 				Exception{
			try{
				System.out.println("Client Started");
				System.out.println("Ready for 							communication");
				while(true){
					Socket client = new 								Socket(InetAddress.getLocalHost(),1234);
					BufferedReader brc = new BufferedReader(new InputStreamReader(System.in));
					System.out.print("c>>>:");
					String linec=brc.readLine();
					PrintWriter pwc=new 							PrintWriter(client.getOutputStream(),true);
					pwc.println(linec);
					BufferedReader brc1=new 									BufferedReader(new 						InputStreamReader(client.getInputStream()));
					String msgc=brc1.readLine();
					System.out.print("s>>>:"+msgc);
					System.out.println();
					if(msgc.equals("bye")){
						System.out.println("-------");
						break;
					}
					client.close();
					pwc.close();
				}
		}
		catch(Exception e){
			System.out.println("-------");
		}
	}
}
