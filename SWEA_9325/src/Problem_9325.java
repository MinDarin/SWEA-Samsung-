import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem_9325 {
	public static void main(String[] argv)
	{
		run r = new run();
		r.reset();
		int testcase = r.first_read();
		for(int i = 0 ; i<testcase ; i++)
		{
		r.loop_read();
		r.run_buy_check();
		r.reset();
		}
	}
}

class run
{
	int TC = 0;
	int N = 0; //최대물건
	int P = 0; //소지금액
	int D = 0; //쿠폰
	int start_idx = 0;
	int end_idx = 0;
	String[] A = null;
	boolean TorF = false;
	FileReader fd = null;
	BufferedReader bfd = null;
	run(){	}
	public void reset()
	{
			this.N = 0;//초기화 블록
			this.P = 0;
			this.D = 0;
			this.start_idx = 0;
			this.end_idx = 0;
			this.TorF = false;
	}
	
	public int first_read()
	{
		Integer i  = 0;
		try
		{
			this.fd = new FileReader("input.txt");
			this.bfd = new BufferedReader(fd);
			String temp = bfd.readLine();
			System.out.println(temp);
			i = Integer.parseInt(temp);
		}
		catch(Exception e)
		{}
		finally
		{
				try {
					fd.close();
				} catch (IOException e) { }
		}
		return i;
	}

	public void loop_read()
	{
		try
		{
			String temp = bfd.readLine();
			String[] arg = temp.split(" ");
			this.N = Integer.parseInt(arg[0]);
			this.P = Integer.parseInt(arg[1]);
			this.D = Integer.parseInt(arg[2]);
			String temp_s = bfd.readLine();
			this.A = temp_s.split(" ");
			this.end_idx= A.length - 1; 
		}
		catch(Exception e)
		{}
	}
	public void run_buy_check()
	{
		int count=0;
		while (TorF == false)
		{
		buy_check buy = new buy_check(start_idx,end_idx,P,D,A);
		TorF = buy.min();
			if (TorF == false)
			{
				if (Integer.parseInt(A[start_idx]) > Integer.parseInt(A[end_idx]))
					this.start_idx++;
				else this.end_idx--;
			}
		}
		System.out.print(start_idx);
		System.out.print(end_idx);
		System.out.println(end_idx-start_idx+1);
	}
}

class buy_check
{
 	int min_sum = 99999;
	int temp_sum = 0;
	int run = 0;
	int end = 0;
	int coupon = 0;
	int money = 0;
	int start = 0;
	String[] arr = null;
	buy_check(int start, int end, int money, int coupon, String[] s)
	{
		this.arr = s;
		this.money = money;
		this.end = end;
		this.start = start;
		this.coupon = coupon;
		this.run = end - start - coupon + 1;
	}
	public boolean min()
	{
	for (int m = 0; m <= run; m++)
	{
		temp_sum = 0;
		for (int i = start; i <= end; i++)
		{
			temp_sum += Integer.parseInt(arr[i]);
		}
		for (int j = m; j < m + coupon; j++)
			temp_sum -= Integer.parseInt(arr[j]);
		if (min_sum > temp_sum)
			min_sum = temp_sum;
	}
		if(min_sum > money)
			return false;
		return true;
	}
}