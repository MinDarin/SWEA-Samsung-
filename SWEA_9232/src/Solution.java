/////////////////////////////////////////////////////////////////////////////////////////////
// �⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
// �Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
// ǥ�� �Է� ����
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
// b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
// g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
// var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
// AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
// ǥ�� ��� ����
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
//import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/* 
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int top = 0;
			int n = 0;
			int p = 0;
			n = sc.nextInt();
			p = sc.nextInt();
			top = n;
			int[] floor = new int[n+1];
			int[] disk = new int[p+1];
			int min_floor = 999; //floor ����
			int min_position = 0;
			int temp_floor = 0;
			top = p+1;
			for(int i = 1; i<= n ; i++)
			{
				temp_floor = sc.nextInt();
				if(temp_floor >= min_floor)
				{
					floor[i] = min_floor;
				}
				else
				{
					floor[i] = temp_floor;
					min_floor = temp_floor;
				}
			}
			int temp_disk = 0;
			boolean exit_flag = false;
			boolean loop_flag = false;
			for(int j = 1; j<= p ; j++)
			{
				temp_disk = sc.nextInt();	
				int start = 1;
				int end = top-1;
				int mid = (start+end)/2;
				loop_flag = false;
				while(start <mid && mid <end)//class��ü�� ���� ������.. merge �κ�
				{
					loop_flag = true;
					mid = (end+start)/2;
					if(temp_disk > floor[mid])
					{
						end = mid-1;
					}
					else if(temp_disk < floor[mid])
					{
						start = mid+1;
					}
					else 
					{
						start = mid;
					}
				}
				if(start == mid && temp_disk <=floor[mid+1])
				{
					top--;
				}
				if(top <= p-j)
				{
					exit_flag = true;
					if(p-j!=0)
						sc.nextLine();
					break;
				}
				else if(top == 2 && p-j==1)
				{
					temp_disk = sc.nextInt();	
					if(floor[1] < temp_disk)
					{
					exit_flag = true;
					}
					else
					{
					top--;
					}
					break;
				}
				else top = mid;
			}
			if(exit_flag)
				System.out.println("#"+test_case+" 0");
			else 
				System.out.println("#"+test_case+" "+top);
		}
	}
}
