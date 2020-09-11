import java.util.*;
import java.io.*;
import java.util.InputMismatchException;

class bhulko
{
	Scanner in=new Scanner(System.in);
	String deep;
	String name()
   { 
		String s;  
     int flag=0;
	while(true)
		{		
     	try
		{
		 System.out.print("Enter your Name :- ");
		 s=in.nextLine();
		 int n=s.length();
		 for(int i=0;i<n;i++)
		 {
			 int value=(int)s.charAt(i);
			 if((value>=65 && value<=91) || (value>=97 && value<=122))
			 { 
				flag=1;
		       continue;
			 }
			 else
			 { 
		        flag=0;
				break;
			 }
		 }
		if(flag==1) break;
		else 
		{ 
			System.out.println("\nPlz Enter the valid name");
		}
		}
		catch(InputMismatchException e)
		{ 
			System.out.println("Enter the Valid Name");
			deep=in.nextLine();
		}
	}
		return s;
   }
	String contact()
	{
		String n;
		int flag=0;
		while(true)
		{
		    System.out.print("Enter your Conatact Number :- ");
			n=in.nextLine();
			int  m=n.length();
			if(m!=10)
			{ System.out.println("\nPlz Enter the valid contact number");
		      continue;
			}
			for(int i=0;i<n.length();i++)
			{
				if((int)n.charAt(i)>=48 && (int)n.charAt(i)<=57)
				{  flag=1;
				continue;}
				else
				{
					flag=0;
					System.out.println("Please Enter valid number ");
					break;
				}
			}
			if(flag==1) break;
		}
		return n;	
	}

}

class admin
{
		bhulko bu=new bhulko();
		Scanner in=new Scanner(System.in);
		
	void Signup() throws IOException
	{
		BufferedWriter bf=new BufferedWriter(new FileWriter("./SignupAd.txt"));
		bf.write("Username :- "+bu.name()+"\n");
		System.out.print("Enter Your Password :- ");
		String pa=in.nextLine();
		bf.write("Password :- "+pa+"\n");
		bf.close();
		
	}
	
	void Login() throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("./SignupAd.txt"));
		BufferedWriter bf=new BufferedWriter(new FileWriter("./loginAd.txt"));
		BufferedReader br1=new BufferedReader(new FileReader("./loginAd.txt"));
		bf.write("Username :- "+bu.name()+"\n");

		System.out.print("Enter Your Password :- ");
		String p=in.nextLine();
		bf.write("Password :- "+p+"\n");
		bf.close();
		
		int n,k;
		while((n=br.read())!=-1)
		{
			k=br1.read();
			if((char)n==(char)k)
				continue;
			else
			{
				System.out.println("Incorrect Password or Username.");
				return;
			}
		}
		System.out.println("You are successfully login.");	
	}
}

class seller
{
	int flag=0,temp=0;
	Scanner in=new Scanner(System.in);
	bhulko bu=new bhulko();
	String k;
	void Signup() throws IOException
	{
		
		String s,s2,s3;
		BufferedWriter bf=new BufferedWriter(new FileWriter("./SignupSel.txt",true));
		BufferedReader br=new BufferedReader(new FileReader("./SignupSel.txt"));
		
		do
		{
		
		s=bu.name();
		s2="Username :- ";
		s3=s2.concat(s);
		while((k=br.readLine())!=null)
		{
			if(k.equals(s3))
				{
					System.out.println("Please choose differnt username.");
					temp=1;
					k=br.readLine();
					break;
				}
			else 
			{
					temp=0;
					
			}
		}
		s3=null;
		}while(temp==1);
		bf.write("Username :- "+s+"\n");		
		System.out.print("Enter Your Password :- ");
		String pa=in.nextLine();
		bf.write("Password :- "+pa+"\n");
		bf.close();
	}
	
	void Login() throws IOException
	{
		int temp=0;
		do{
		BufferedReader br=new BufferedReader(new FileReader("./SignupSel.txt"));
		BufferedWriter bf=new BufferedWriter(new FileWriter("./loginSel.txt"));
		BufferedReader br1=new BufferedReader(new FileReader("./loginSel.txt"));
		bf.write("Username :- "+bu.name()+"\n");

		System.out.print("Enter Your Password :- ");
		String p=in.nextLine();
		bf.write("Password :- "+p+"\n");
		bf.close();
		int c=0,i=0;
		String s,k;
		boolean q=false;
		k=br1.readLine();
		while((s=br.readLine())!=null && c<2)
		{
			i++;
				q=s.equals(k);
				if(q)
				{
					c++;
					flag=1;
					k=br1.readLine();
					if(c-i!=1)
						flag=0;
					if(c==2)
						break;
					i=0;
				}
				else
					flag=0;
		}
			if(flag==0)
			{
				System.out.println("Incorrect Password or Username.");
				temp=1;
			}
			else
			{
				System.out.println("You are successfully login.");
				temp=0;
				return;
			}
		}while(temp==1);
	}
	
	void details() throws IOException
	{
		BufferedWriter bf=new BufferedWriter(new FileWriter("./seller.txt",true));
		bf.write("Name :- "+bu.name()+"\n");
		bf.write("Contact No. :- "+bu.contact()+"\n");
		bf.close();
	}

	void product() throws IOException
	{
		String s;
		int flag=0,i;
		char ch;
		BufferedWriter bf=new BufferedWriter(new FileWriter("./seller.txt",true));
		System.out.print("Enter your product Name :- ");
		bf.write("Product Name :- "+bu.name()+"\n");
		bf.close();
		
	}
	void price() throws IOException
	{
		BufferedWriter bf=new BufferedWriter(new FileWriter("./seller.txt",true));
		
		String n;
		int flag=0;
		while(true)
		{
		    System.out.print("Enter your Price :- ");
			n=in.nextLine();
			int  m=n.length();
			
			for(int i=0;i<n.length();i++)
			{
				if((int)n.charAt(i)>=48 && (int)n.charAt(i)<=57)
				{  flag=1;
				continue;}
				else
				{
					flag=0;
					System.out.println("Please Enter valid number ");
					break;
				}
			}
			if(flag==1) break;
		}
		bf.write(n+"\n");
		bf.close();
	}
		
}

class buyer
{
	int flag=0,temp=0;
	Scanner in=new Scanner(System.in);
	bhulko bu=new bhulko();
	String k;
	void Signup() throws IOException
	{
		String s,s2,s3;
		BufferedWriter bf=new BufferedWriter(new FileWriter("./SignupBuy.txt",true));
		BufferedReader br=new BufferedReader(new FileReader("./SignupBuy.txt"));
		
		do
		{
		
		s=bu.name();
		s2="Username :- ";
		s3=s2.concat(s);
		while((k=br.readLine())!=null)
		{
			if(k.equals(s3))
				{
					System.out.println("Please choose differnt username.");
					temp=1;
					k=br.readLine();
					break;
				}
			else 
			{
					temp=0;
					
			}
		}
		s3=null;
		}while(temp==1);
		bf.write("Username :- "+s+"\n");		
		System.out.print("Enter Your Password :- ");
		String pa=in.nextLine();
		bf.write("Password :- "+pa+"\n");
		bf.close();
	}
	
	void Login() throws IOException
	{
		int temp=0;
		do
		{
		BufferedReader br=new BufferedReader(new FileReader("./SignupBuy.txt"));
		BufferedWriter bf=new BufferedWriter(new FileWriter("./loginBuy.txt"));
		BufferedReader br1=new BufferedReader(new FileReader("./loginBuy.txt"));
		bf.write("Username :- "+bu.name()+"\n");

		System.out.print("Enter Your Password :- ");
		String p=in.nextLine();
		bf.write("Password :- "+p+"\n");
		bf.close();
		
		int c=0,i=0;
		String s,k;
		boolean q=false;
		k=br1.readLine();
		while((s=br.readLine())!=null && c<2)
		{
			i++;
				q=s.equals(k);
				if(q)
				{
					c++;
					flag=1;
					k=br1.readLine();
					if(c-i!=1)
						flag=0;
					if(c==2)
						break;
					i=0;
				}
				else
					flag=0;
		}
			if(flag==0)
			{
				System.out.println("Incorrect Password or Username.");
				temp=1;
			}
			else
			{
				System.out.println("You are successfully login.");	
				return;
			}
		}while(temp==1);
	}
	
	void details() throws IOException
	{
		BufferedWriter bf=new BufferedWriter(new FileWriter("./buyer.txt",true));
		bf.write("Username :- "+bu.name()+"\n");
		bf.write("Contact :- "+bu.contact()+"\n");
		bf.close();
	}
	
	void productDetail() throws IOException
	{
		int i;
		String s;
		BufferedReader br=new BufferedReader(new FileReader("./seller.txt"));
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
		}
	}
	
	void select() throws IOException
	{
		Scanner in=new Scanner(System.in);
		long time;
		String s,k,a,k1,f,f1;
		int n,temp=0;
		BufferedWriter bf=new BufferedWriter(new FileWriter("./select.txt"));
		BufferedReader br=new BufferedReader(new FileReader("./seller.txt"));
		BufferedReader br1=new BufferedReader(new FileReader("./select.txt"));
		System.out.println("Please Enter product name you want to buy ");
		s=in.nextLine();
		bf.write("Product Name :- "+s+"\n");
		bf.close();
		boolean q=false,e=false;
		int flag=0,flag1=0;
		k=br1.readLine();
		while((s=br.readLine())!=null)
		{
			
				q=s.equals(k);
				if(q)
				{
					flag=1;
					break;
				}
			
		}
		k1=br.readLine();
		//System.out.println(k1);
		int p=Integer.parseInt(k1); 
		if(flag==0)
		{
			System.out.println("Item doesn't found!!!!");
		}
		else
		{
			BufferedWriter bf1=new BufferedWriter(new FileWriter("./biding.txt"));
			BufferedReader br2=new BufferedReader(new FileReader("./biding.txt"));
			while((a=br2.readLine())!=null)
			{
				e=k.equals(a);
				if(e)
				{
					temp=1;
					break;
				}
				else
					temp=0;
					
			}
			
			
			if(temp==1)
			{
				f1=br2.readLine();
				System.out.println(f1);
				
				f=br2.readLine();
				System.out.println(f);
				
			long time1=Long.parseLong(f);
			System.out.println(time1);
			
			long time2;
			int bid=Integer.parseInt(f1);
				this.details();
				System.out.println("Enter your biding amount ");
				n=in.nextInt();
				time2=System.currentTimeMillis();
				if(time2-time1 > 100000)
				{
					flag1=1;
					System.out.println("Item has been sold!");
				}
				if(n < bid)
				{
					System.out.println("Please enter higher bid ");
					flag1=1;
				}
				
				if(flag==0)
				{
					bf1.write(k+"\n"+n+"\n"+time2+"\n");
				}

			}
			else
			{
				this.details();
				System.out.println("Enter your biding amount ");
				n=in.nextInt();
				time=System.currentTimeMillis();
				if(n>p)
				{
					bf1.write(k+"\n"+n+"\n"+time+"\n");
					bf1.close();
				}	
			}	
		}	
	}
}

class kaju
{
	public static void main(String args[]) throws IOException
	{
		String g,w;
		int choice;
		Scanner in=new Scanner(System.in);
		bhulko bh=new bhulko();
		admin obj=new admin();
		seller ob=new seller();
		buyer o=new buyer();
		int flag=0,flag2=1,flag3=0,flag4=0;
		String s;
		
		do
		{
		System.out.println("Choose any one\n1.Admin\n2.Seller\n3.Buyer ");
		 s=in.nextLine();
		if(s.equals("1") || s.equals("2") || s.equals("3")) 
		{
			flag=1; 
			break;
		}
		 else 
			{
				 System.out.println("Please choose correct option!!!!!\n");
		         flag=0;
			}
		} while(flag==0);
        switch(s)
		{
			case "1":
				System.out.println("Enter\n1.Login\n2.Signup\n");
				int c=in.nextInt();
				if 	(c==1)
					obj.Login();
				else
					obj.Signup();
				
				break;
				
				
			case "2":
			int ch=0,flag8=0;
			do
			{
			try{
				Scanner in1=new Scanner(System.in);
				System.out.println("Enter\n1.Login\n2.Signup\n");
				ch=in1.nextInt();
				if(ch==1||ch==2)
				{
					flag2=0;
					break;
				}
				else
				{
					System.out.println("Please Enter valid Number. ");
					flag2=1;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please Enter valid Number. ");
				flag2=1;
			}
			}while(flag2==1);
				
				if(ch==1)
				{
					ob.Login();
					do
					{
					System.out.println("Do you want to sell any items then write yes else no ");
					g=in.nextLine();
					//g=in.nextLine();
					if(g.equals("yes")!=true && g.equals("YES")!=true && g.equals("no")!=true && g.equals("NO")!=true )
					{
						System.out.println("Please Enter Correct option");
					}
					else if(g.equals("yes")==true && g.equals("YES")==true && g.equals("no")==true && g.equals("NO")==true)
						break;
						
					}while(g.equals("yes")!=true && g.equals("YES")!=true && g.equals("no")!=true && g.equals("NO")!=true );
					do
					{
					if(g.equals("yes")||g.equals("YES"))
					{
						ob.details();
						ob.product();
						ob.price();
						System.out.println("Your item has been successfully added for selling");
					}
					else if(g.equals("NO")||g.equals("no"))
					{
						System.out.println("You should signout and login in Buyer section for buying item. ");
						System.out.println("Enter\n1.Login\n2.Signup\n3.Exit");
						int cho=in.nextInt();
						if(cho==1)
							o.Login();
						else if(cho==2)
							o.Signup();
						else
						{
							System.out.println("Thank you for visiting......");
							return;
						}
					}
					
						System.out.println("If you want to add any other item then write yes else no ");
						w=in.nextLine();
					if(w.equals("no"))
					{
						System.out.println("Thank you for visiting......");
					}
					}while(w.equals("yes")||w.equals("YES"));
				}
				else
				{
					ob.Signup();
					
					String n;
			int rar=0,x;
			while(true)
			{
		   System.out.println("If you want to stay online then press 1 else 0 for exit.");
		   
			n=in.nextLine();
			
			int  m=n.length();
			for(int i=0;i<n.length();i++)
			{
				if((int)n.charAt(i)>=48 && (int)n.charAt(i)<=57)
				{  rar=1;
				continue;}
				else
				{
					rar=0;
					System.out.println("Please Enter valid number ");
					break;
				}
			}
			if(rar==1) break;
		}
			x=Integer.parseInt(n);
					if(x==0)
					{
						System.out.println("Thank you for visiting... ");
						return;
					}
					else
					{
					do{
						g=in.nextLine();
						System.out.println("Do you want to sell any items then write yes else no ");
					g=in.nextLine();
					
					if(g.equals("yes")!=true && g.equals("YES")!=true && g.equals("no")!=true && g.equals("NO")!=true )
					{
						System.out.println("Please Enter Correct option");
					}
					}while(g.equals("yes")!=true && g.equals("YES")!=true && g.equals("no")!=true && g.equals("NO ")!=true  );
					do
					{
					if(g.equals("yes")||g.equals("YES"))
					{
						ob.details();
						ob.product();
						ob.price();
						System.out.println("Your item has been successfully added for selling");
					}
					else if(g.equals("NO")||g.equals("no"))
					{
						System.out.println("You should signout and login in Buyer section for buying item. ");
						System.out.println("Enter\n1.Login\n2.Signup\n3.Exit");
						int cho=in.nextInt();
						if(cho==1)
							o.Login();
						else if(cho==2)
							o.Signup();
						else
						{
							System.out.println("Thank you for visiting......");
							return;
						}
					}
				
					System.out.println("If you want to add any other item then write yes else no ");
					w=in.nextLine();
					
					}while(w.equals("yes")||w.equals("YES"));
					}
						
				}
				break;
			case "3":
				int cho=0;
			do
			{
			try{
				Scanner in1=new Scanner(System.in);
				System.out.println("Enter\n1.Login\n2.Signup\n");
				cho=in1.nextInt();
				if(cho==1||cho==2)
				{
					flag4=0;
					break;
				}
				else
				{
					System.out.println("Please Enter valid Number. ");
					flag4=1;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please Enter valid Number. ");
				flag4=1;
			}
			}while(flag4==1);
			
				if 	(cho==1)
					o.Login();
				else
					o.Signup();
				do
				{
				System.out.println("If you want to see product details then press 1 else 0 for Exit ");
				choice=in.nextInt();
				if(choice==1)
				{
					o.productDetail();
					break;
				}
				else if(choice==0)
				{
					System.out.println("Thank you for visiting. ");
					return;
				}
				else
				{
					System.out.println("You didn't choose any appropriate choice ");
				}
				}while(choice!=1||choice!=0);
				o.select();
				break;
		}	
	}
}