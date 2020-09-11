void Signup() throws IOException
	{
		String k,s,s2,s3;
		int temp=0;
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