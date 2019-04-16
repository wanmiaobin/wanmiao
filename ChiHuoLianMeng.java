import java.util.Scanner;
/**
 * 吃货联盟订餐系统
 * @author w
 *
 */
public class ChiHuoLianMeng {
	public static void main(String[] args) {
		////数据主体：一组订单信息
		String[] names=new String[4];//订餐人
		String[] dishMegs=new String[4];//所定餐品信息
		int[] times=new int[4];//送餐时间
		String[] addresses=new String[4];//送餐地址
		int[] states=new int[4];//订单状态   (0:已预定 ;   1:已完成)
		double[] sumPrices=new double[4];//总金额
		
		//初始化2条订单信息
		names[0]="张利";
		dishMegs[0]="鱼香肉丝 1份";
		times[0]=12;
		addresses[0]="天成路209号";
		states[0]=0;
		sumPrices[0]=24.0;
		//
		names[1]="张利";
		dishMegs[1]="红烧带鱼 2份";
		times[1]=12;
		addresses[1]="天成路209号";
		states[1]=1;
		sumPrices[1]=76.0;
		
		////数据主体：一组餐品信息
		//供选择的菜品信息
		String[] dishNames={"红烧带鱼","鱼香肉丝","时令蔬菜"}; //菜品名称
		double[] prices={38.0,18.0,10.0}; //菜品单价
		int[] praiseNums=new int[3];//点赞数
		
		//循环（do while）
		//循环操作：
			//显示主菜单
			//提示用户输入功能编号，并执行相应功能
			//提示输入0返回
		//循环条件：
			//输入0
		
		Scanner input=new Scanner(System.in);
		
		int num=-1;//记录用户输入的数字
		
		do{
			
		//循环操作：
			//显示主菜单
			System.out.println("******************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.删除订单");
			System.out.println("4.签收订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("******************************");
		//提示用户输入功能编号，并执行相应功能
			System.out.println("请选择：");
			int choose=input.nextInt(); //记录用户选择编号
			
			boolean isAdd=false; //true: 找到了空位置     //false:没找到空位置
			switch(choose){
			case 1:
				//我要订餐
				System.out.println("**********我要订餐**********");
				//查找要插入的位置
				for(int i=0;i<names.length;i++){
					//如果找到空的位置，记录下来
					if(names[i]==null){
						isAdd=true; //记录已找到一个为空的位置
						//执行插入操作
						//a:显示所有可供选择的餐品信息
						System.out.println("序号\t餐品名\t单价\t点赞数");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"元";
							String praise=praiseNums[j]+"赞";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						
						//输入所选餐品的编号以及份数
						System.out.println("请选择餐品编号：");
						int chooseDish=input.nextInt();
						System.out.println("请选择份数：");
						int number=input.nextInt();
						//整合餐品数据
						String dishMeg=dishNames[chooseDish-1]+" "+number+"份";
						
						//b:输入订餐人姓名
						System.out.println("请输入订餐人姓名：");
						String name=input.next();
						
						//c:输入送餐时间
						System.out.println("请输入订餐时间（10~20整点送餐）：");
						int time=input.nextInt();
						//如果输错了，重复输入
						while(time<10||time>20){
							System.out.println("对不起，您的输入有误，请输入10~20之间的整数：");
							time=input.nextInt();
						}
						
						//d:输入送餐地址
						System.out.println("请输入送餐地址：");
						String address=input.next();
						
						//e:计算餐费
						double sumPrice=prices[chooseDish-1]*number;
						//送餐费，当餐费达到50元时，免6元送餐费
						double deliCharge=(sumPrice >=50 ? 0 : 6 );
						
						//显示订单信息
						System.out.println("订餐成功！");
						System.out.println("您订的是:"+dishMeg);
						System.out.println("订餐人:"+name);
						System.out.println("送餐时间:"+time+"点");
						System.out.println("送餐地址:"+address);
						System.out.println("餐费："+sumPrice+",送餐费："+deliCharge+"元");
						System.out.println("总金额："+(sumPrice+deliCharge)+"元");
						
						//保存数据
						names[i]=name;
						dishMegs[i]=dishMeg;
						times[i]=time;
						addresses[i]=address;
						sumPrices[i]=sumPrice+deliCharge;
						
						break;
					}
				}
				//没找到为空的位置，提示信息
				if(!isAdd){
					System.out.println("对不起，您的餐袋已满。");
				}
				break;
			case 2:
				//查看餐袋
				System.out.println("************查看餐袋************");
				System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t送餐地址\t\t总金额\t状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"点";
						String sumPrice=sumPrices[i]+"元";
						String state=states[i]==0 ? "已预定": "已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
					}
				}
				break;
			case 3:
				//删除订单
				System.out.println("***************删除订单***************");
				System.out.println("请输入要删除的订单序号");
				int xuHao = input.nextInt();
				int delIndex=-1; //找到的要删除的订单下标
				boolean isDelFind=false;   //记录是否找到此条订单
				//找到此订单  
				for(int i=0;i<names.length;i++){
					//找到的订单已签收，可删除
					if(names[i]!=null && states[i]==1 && xuHao==i+1){
						isDelFind=true;
						delIndex=i;
						break;
					}
					//找到的订单未签收，不能删除
					else if(names[i]!=null && states[i]==0 && xuHao==i+1){
						isDelFind=true;
						System.out.println("您选择的订单未签收，不能删除！");
						break;
					}
				}
				//未找到此条订单
				if(!isDelFind){
					System.out.println("对不起，此条订单不存在。");
				}
				
				//执行删除操作
				if(delIndex!=-1){
					//从要删除的元素后面一个开始，到数组最后一个元素，依次向前移动一位，覆盖数据。
					for(int i=delIndex+1;i<names.length;i++){
						names[i-1]=names[i];
						dishMegs[i-1]=dishMegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
						prices[i-1]=prices[i];
						
					}
					//最后一位数据清空
					names[names.length-1]=null;
					dishMegs[dishMegs.length-1]=null;
					times[times.length-1]=0;
					addresses[addresses.length-1]=null;
					states[states.length-1]=0;
					//
					System.out.println("订单删除成功！");
				}
				break;
			case 4:
				//签收订单
				System.out.println("*************签收订单**************");
				System.out.println("请输入要签收的订单序号：");
				int signOrderId=input.nextInt();
				boolean isFind=false;  //记录是否找到了这条订单，false：没找到。	true:找到了。
				//查找这条订单(循环遍历)
				for(int i=0;i<names.length;i++){
					//1.找到，状态是已完成（已经签收完毕）：提示不能再次签收
					//2.找到，状态是已预定（没有完成签收）：可以签收
					if(names[i]!=null && states[i]==1 && signOrderId==i+1){
						System.out.println("对不起，您选择的订单已经签收，不能再次签收。");
						isFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i]=1; //状态值改为已完成状态
						isFind=true;
						System.out.println("订单签收成功！");
						break;
					}
				}
				
				//3.对不起，此订单不存在
				//条件判断：如果没找到这条订单，才去提示没有找到
				if(!isFind){
					System.out.println("对不起，此订单不存在。");
				}
				break;
			case 5:
				//我要点赞
				System.out.println("**************我要点赞*************");
				//1.显示所有可供点赞的餐品信息
				System.out.println("序号\t餐品名\t单价\t点赞数");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"元";
					String praise=praiseNums[j]+"赞";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				//2.输入要点赞的餐品序号
				System.out.println("请输入要点赞的餐品序号：");
				int dishId=input.nextInt();
				//
				//3.该序号的餐品点赞数加1
				praiseNums[dishId-1]++;
				
				//4.显示
				System.out.println("点赞成功!");
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"赞");
				
				break;
			case 6:
				//退出系统
				break;
			default:
				//错误操作
				break;
			}
			//当用户输入功能编号为1~5之外的数字时，退出循环，否则会提示输入0返回。
			if(choose>5||choose<1){
				break;
			}
			
			//提示输入0返回
			System.out.println("输入0返回:");
			num=input.nextInt();
			
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临！");
		
	}
}
