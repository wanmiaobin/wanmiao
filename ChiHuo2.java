import java.util.Scanner;

//

public class ChiHuo2 {
	public static void main(String[] args) {
		////数据主体 订单信息
			//送餐人
			String[] names=new String[4];
			//餐品信息(种类 份数)
			String[] canPinXinXis=new String[4];
			//送餐时间
			int[] shiJians=new int[4];
			//送餐地址
			String[] diZhis=new String[4];
			//订单状态 1是已预定 0是已完成
			int[] zTs=new int[4];
			//订单餐品总金额
			double[] $zongs=new double[4];
			
			//初始化两条订单信息
			names[0]="丁佳佳";
			canPinXinXis[0]="鱼香肉丝1份";
			shiJians[0]=12;
			diZhis[0]="岳阳大道999号";
			zTs[0]=0;
			$zongs[0]=26.0;
			//
			names[1]="丁佳佳";
			canPinXinXis[1]="红烧带鱼2份";
			shiJians[1]=13;
			diZhis[1]="南湖大道西888号";
			zTs[1]=1;
			$zongs[1]=60.0;
			//
		////数据主体 菜单信息
			//餐品名
			String[] canPinnames={"鱼香肉丝","红烧带鱼","时令蔬菜"};
			//单价
			double[] $danJias={20.0, 30.0, 10.0 };
			//点赞数
			int[] dianZans=new int[3];
		/////////////////////////////////////
			//////整体框架
			Scanner input=new Scanner(System.in);
			//用户输入数字0循环
			int yongHu=-1;
			//布尔变量判断退出系统
			boolean tuiChu=false;
			//
			do{
				//显示主菜单
				System.out.println("欢迎使用“吃货联盟订餐系统”");
				System.out.println("********************主菜单********************");
				System.out.println("1.我要订餐");
				System.out.println("2.查看餐袋");
				System.out.println("3.签收订单");
				System.out.println("4.删除订单");
				System.out.println("5.我要点赞");
				System.out.println("6.退出系统");
				System.out.println("*********************************************");
				System.out.println("请选择：");
				int xuHao=input.nextInt();
				//用户选择序号功能
				switch(xuHao){
				case 1:
					//我要订餐
					System.out.println("***************我要订餐****************");
					//记录空位置下标（各种数据是一致的）
					int kong=-1;
					//查找空位置
					for(int i=0;i<names.length;i++){
						if(names[i]==null){
							kong=i;
							//找到空位置后，循环遍历，显示菜单,   提供用户选择：餐品种类，份数。
							System.out.println("编号\t种类\t单价\t点赞数");
							for(int j=0;j<canPinnames.length;j++){
								System.out.println((j+1)+"\t"+canPinnames[j]+"\t"+$danJias[j]+"元"+"\t"+dianZans[j]+"赞");
							}
					//用户数据写入
							//输入餐品信息
							System.out.println("请输入餐品编号：");
							int bianHao=input.nextInt();
							System.out.println("请输入份数：");
							int fengShu=input.nextInt();
							//整合餐品信息
							String canPinXinXi=canPinnames[bianHao-1]+fengShu+"份";
							//输入姓名
							System.out.println("请输入姓名：");
							String name=input.next();
							//输入时间，错误则重新输入
							System.out.println("请输入送餐时间(10~20之间的整数)：");
							int shiJian=input.nextInt();
							while(shiJian>20||shiJian<10){
								System.out.println("输入错误，重新输入送餐时间(10~20之间的整数)：");
								shiJian=input.nextInt();
							}
							//
							System.out.println("请输入地址：");
							String diZhi=input.next();
							//计算餐品金额
							double $zong=$danJias[bianHao-1]*fengShu;
							//送餐费    餐品总金额大于30则优惠6元送餐费
							double songCan=($zong>30) ? 0.0 : 6.0;
							//显示订单信息
							System.out.println("***************订餐成功，您的订单如下***************");
							System.out.println("您订的是:"+canPinXinXi);
							System.out.println("订餐人："+name);
							System.out.println("送餐时间："+shiJian+"点");
							System.out.println("送餐地址："+diZhi);
							System.out.println("餐品总金额："+$zong+"元;\t送餐费："+songCan+"元");
							System.out.println("订单总金额："+($zong+songCan)+"元");
					//录入订单数据
							//送餐人
							names[i]=name;
							//餐品信息(种类 份数)
							canPinXinXis[i]=canPinXinXi;
							//送餐时间
							shiJians[i]=shiJian;
							//送餐地址
							diZhis[i]=diZhi;
							//订单状态 1是已预定 0是已完成
							zTs[i]=1;
							//订单餐品总金额
							$zongs[i]=$zong+songCan;
							break;
						}
					}
					//没有找到空位置时 kong值不变，提示信息，餐袋已满。
					if(kong==-1){
						System.out.println("对不起，餐袋已满。");
					}
					//
					break;
				case 2:
					//查看餐袋
					System.out.println("*****************查看餐袋****************");
					System.out.println("序号\t姓名\t餐品信息\t\t送餐时间\t送餐地址\t\t餐品金额\t订单状态");
					//循环遍历数据输出
					for(int i=0;i<names.length;i++){
						//输出餐袋数据
						if(names[i]!=null){
						String zT=(zTs[i]==0) ? "已完成":"已预定";//数字转化文字表示订单状态
						System.out.println((i+1)+"\t"+names[i]+"\t"+canPinXinXis[i]+"\t"+shiJians[i]+"点"+"\t"+diZhis[i]+"\t"+$zongs[i]+"元"+"\t"+zT);
						}
					}
					break;
				case 3:
					//签收订单
					System.out.println("********************签收订单*********************");
					//输出当前订单目录(直接看餐袋)
					System.out.println("序号\t姓名\t餐品信息\t\t送餐时间\t送餐地址\t\t餐品金额\t订单状态");
					//循环遍历数据输出
					for(int i=0;i<names.length;i++){
						//输出餐袋数据
						if(names[i]!=null){
						String zT=(zTs[i]==0) ? "已完成":"已预定";//数字转化文字表示订单状态
						System.out.println((i+1)+"\t"+names[i]+"\t"+canPinXinXis[i]+"\t"+shiJians[i]+"点"+"\t"+diZhis[i]+"\t"+$zongs[i]+"元"+"\t"+zT);
						}
					}
					System.out.println("请选择要签收的订单：");
					int qianShou=input.nextInt();
					//判断订单不为空   //以名字信息为判断，其他信息也是一致
					//并且判断订单未签收  则进行签收
					if(names[qianShou-1]!=null && zTs[qianShou-1]==1){
						zTs[qianShou-1]=0;
						System.out.println("签收完成！");
					}
					//订单不为空，但是已完成签收，则提示信息已经完成过
					else if(names[qianShou-1]!=null && zTs[qianShou-1]==0){
						System.out.println("此订单已签收，无需再签收。");
					}else{
						System.out.println("此订单不存在！");
						
					}
					break;
				case 4:
					//删除订单
					System.out.println("******************删除订单****************");
					//输出当前订单目录(直接看餐袋)
					System.out.println("序号\t姓名\t餐品信息\t\t送餐时间\t送餐地址\t\t餐品金额\t订单状态");
					//循环遍历数据输出
					for(int i=0;i<names.length;i++){
						//输出餐袋数据
						if(names[i]!=null){
						String zT=(zTs[i]==0) ? "已完成":"已预定";//数字转化文字表示订单状态
						System.out.println((i+1)+"\t"+names[i]+"\t"+canPinXinXis[i]+"\t"+shiJians[i]+"点"+"\t"+diZhis[i]+"\t"+$zongs[i]+"元"+"\t"+zT);
						}
					}
					//选择序号
					System.out.println("请选择要删除的订单：");
					int shanChu=input.nextInt();
					//找到的标记
					boolean zhaoDao=false;  //true找到了     //false没找到
					//循环遍历找到这个序号的订单
					//该订单已完成才能删除
					for(int j=0;j<names.length;j++){
						if(j==shanChu-1 && names[j]!=null && zTs[j]==0){
							zhaoDao=true; //找到了
							//用要删除订单后面的订单数据覆盖前面的，循环依次覆盖移位，
							//最后一位不进行被覆盖操作，否则覆盖最后一位的位越界。
							//最后一位数值会清空，不进入循环也不影响操作。
							for(int i=j;i<names.length-1;i++){
								names[i]=names[i+1];
								canPinXinXis[i]=canPinXinXis[i+1];
								shiJians[i]=shiJians[i+1];
								diZhis[i]=diZhis[i+1];
								zTs[i]=zTs[i+1];
								$zongs[i]=$zongs[i+1];
							}
							//清空最后一个订单数据，腾出空位，就算订单没有满，此操作也不会影响
							names[names.length-1]=null;
							canPinXinXis[canPinXinXis.length-1]=null;
							shiJians[shiJians.length-1]=0;
							diZhis[diZhis.length-1]=null;
							zTs[zTs.length-1]=0;
							$zongs[$zongs.length-1]=0.0;
							System.out.println("订单删除成功！");
							break;
						}else if(j==shanChu-1 && names[j]!=null && zTs[j]==1){
							zhaoDao=true; //找到了
							System.out.println("该订单未完成，不能删除！");
							break;
						}
					}
					//没找到则提示该订单不存在
					if(!zhaoDao){
						System.out.println("该订单不存在！");
					}
					
					break;
				case 5:
					//我要点赞
					boolean panduan=false;
					System.out.println("*****************目前菜单热度***************");
					System.out.println("编号\t种类\t单价\t点赞数");
					for(int j=0;j<canPinnames.length;j++){
						System.out.println((j+1)+"\t"+canPinnames[j]+"\t"+$danJias[j]+"元"+"\t"+dianZans[j]+"赞");
					}
					System.out.println("请选择点赞餐品序号：");
					int dianZan=input.nextInt();
					//循环遍历找到餐品数据
					for(int i=0;i<canPinnames.length;i++){
						if(i==dianZan-1){
							//点赞数加1
							panduan=true;
							dianZans[i]++;
							System.out.println("点赞成功！");
							System.out.println(canPinnames[i]+" "+dianZans[i]+"赞");
							break;
						}
					}
					if(!panduan){
						System.out.println("输入序号错误！");
					}
					
					break;
				case 6:
					tuiChu=true;
					//退出系统
					break;
				default:
					tuiChu=true;
					//
					break;
				}
				if(tuiChu){
					break;
				}
				System.out.println("请输入0返回");
				yongHu=input.nextInt();
			}while(yongHu==0);
			
			System.out.println("谢谢使用，欢迎再来！");
			
	}
}
