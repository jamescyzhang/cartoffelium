package cartoffelium.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CServer implements Runnable
{

	public class CServerThread extends Thread
	{

		public Socket socket = null;

		public LinkedList<String> inputQueue, outputQueue;

		public int num;
		public boolean active = true;

		public PrintWriter out;
		public BufferedReader in;
		public String inputLine, outputLine;

		public CServerThread(Socket socket, int num)
		{
			super("CServerThread");
			this.socket = socket;
			inputQueue = new LinkedList<>();
			this.num = num;
		}

		@Override
		public String toString()
		{
			return "Thread: SOCKET " + socket.toString() + " NUM " + num;
		}

		public void run()
		{

			try
			{
				inputQueue = new LinkedList<>();
				outputQueue = new LinkedList<>();
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));

				System.out.println("CONNECTION ESTABLISHED.");
				System.out.println(this);
				out.println("CONNECTION ESTABLISHED.");

				Thread inThread = new Thread(new Runnable()
				{

					@Override
					public void run()
					{
						try
						{
							while (active)
							{
								if ((inputLine = in.readLine()) != null)
								{
									inputQueue.add(inputLine);
									// System.out.println(inputLine);
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
				new Thread(new Runnable()
				{

					@Override
					public void run()
					{
						while (active)
						{
							try
							{
								Thread.sleep(1000);
							}
							catch (InterruptedException e)
							{
								e.printStackTrace();
							}
							out.println("TICK");
							out.flush();
						}
					}
				}).start();
				System.out.println("Thread initiated");
				while (true)
				{

					String string = "";
					// System.out.println(inputQueue.size());
					try
					{
						string = inputQueue.remove();
					}
					catch (NoSuchElementException e)
					{
						continue;
					}
					System.out.println(this + ": " + string);
					if (string.toUpperCase().equals("PING"))
					{
						outputQueue.add("PONG");
					}
					if (string.toUpperCase().equals("QUIT"))
					{
						try
						{
							outputQueue.add("$%SOCKET_CLOSE");
							active = false;
							inThread.join();
							socket.shutdownOutput();
							socket.shutdownInput();
							socket.close();
							interrupt();
						}
						catch (SocketException | InterruptedException e)
						{
						}

						return;
					}
					try
					{
						string = outputQueue.remove();
					}
					catch (NoSuchElementException e)
					{
						continue;
					}
					out.println(string);
					out.flush();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	ServerSocket socket;
	boolean listening = true;
	int connectionCount;

	ArrayList<CServerThread> threads = new ArrayList<>();

	@Override
	public void run()
	{
		try
		{
			connectionCount = 0;
			socket = new ServerSocket(10000);
			System.out.println(socket);
			while (listening)
			{
				CServerThread thread = new CServerThread(socket.accept(), connectionCount);
				threads.add(thread);
				thread.start();
				System.out.println("DING!");
				connectionCount++;
			}
		} catch (IOException e)
		{
			System.err.println("Could not listen.");
			System.exit(-1);
		}
	}

	public static void main(String[] args)
	{
		CServer server = new CServer();
		server.run();
	}

}
