package cartoffelium.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CClient implements Runnable
{

	Socket socket;
	
	Thread inThread, outThread;

	@Override
	public void run()
	{
		try
		{
			socket = new Socket("0.0.0.0", 10000);
			outThread = new Thread(new Runnable()
			{

				private Scanner scanner;

				@Override
				public void run()
				{
					try
					{
						PrintWriter writer = new PrintWriter(
								socket.getOutputStream());
						scanner = new Scanner(System.in);
						String command = "";
						while (true)
						{
							if ((command = scanner.nextLine()) != null)
							{
								writer.println(command);
								writer.flush();
								System.out.println(command);
							}
						}
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}

				}
			});
			outThread.start();
			inThread  = new Thread(new Runnable()
			{

				@Override
				public void run()
				{
					try
					{
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						String response = "";
						while (true)
						{
							if ((response = reader.readLine()) != null)
							{
								if (!response.startsWith("$%"))
									System.out.println(response);
								else
								{
									System.out.println(response);
									handleResp(response.substring(2));
								}
							}
						}
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}

				}
			});
			inThread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	protected void handleResp(String str)
	{
		if (str.equals("SOCKET_CLOSE"))
		{
			try
			{
				socket.shutdownOutput();
				socket.shutdownInput();
				inThread.join();
				outThread.join();
				socket.close();
			}
			catch (IOException | InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		CClient client = new CClient();
		client.run();
	}

}
