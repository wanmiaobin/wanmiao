import java.util.Scanner;
/**
 * �Ի����˶���ϵͳ
 * @author w
 *
 */
public class ChiHuoLianMeng {
	public static void main(String[] args) {
		////�������壺һ�鶩����Ϣ
		String[] names=new String[4];//������
		String[] dishMegs=new String[4];//������Ʒ��Ϣ
		int[] times=new int[4];//�Ͳ�ʱ��
		String[] addresses=new String[4];//�Ͳ͵�ַ
		int[] states=new int[4];//����״̬   (0:��Ԥ�� ;   1:�����)
		double[] sumPrices=new double[4];//�ܽ��
		
		//��ʼ��2��������Ϣ
		names[0]="����";
		dishMegs[0]="������˿ 1��";
		times[0]=12;
		addresses[0]="���·209��";
		states[0]=0;
		sumPrices[0]=24.0;
		//
		names[1]="����";
		dishMegs[1]="���մ��� 2��";
		times[1]=12;
		addresses[1]="���·209��";
		states[1]=1;
		sumPrices[1]=76.0;
		
		////�������壺һ���Ʒ��Ϣ
		//��ѡ��Ĳ�Ʒ��Ϣ
		String[] dishNames={"���մ���","������˿","ʱ���߲�"}; //��Ʒ����
		double[] prices={38.0,18.0,10.0}; //��Ʒ����
		int[] praiseNums=new int[3];//������
		
		//ѭ����do while��
		//ѭ��������
			//��ʾ���˵�
			//��ʾ�û����빦�ܱ�ţ���ִ����Ӧ����
			//��ʾ����0����
		//ѭ��������
			//����0
		
		Scanner input=new Scanner(System.in);
		
		int num=-1;//��¼�û����������
		
		do{
			
		//ѭ��������
			//��ʾ���˵�
			System.out.println("******************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ɾ������");
			System.out.println("4.ǩ�ն���");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("******************************");
		//��ʾ�û����빦�ܱ�ţ���ִ����Ӧ����
			System.out.println("��ѡ��");
			int choose=input.nextInt(); //��¼�û�ѡ����
			
			boolean isAdd=false; //true: �ҵ��˿�λ��     //false:û�ҵ���λ��
			switch(choose){
			case 1:
				//��Ҫ����
				System.out.println("**********��Ҫ����**********");
				//����Ҫ�����λ��
				for(int i=0;i<names.length;i++){
					//����ҵ��յ�λ�ã���¼����
					if(names[i]==null){
						isAdd=true; //��¼���ҵ�һ��Ϊ�յ�λ��
						//ִ�в������
						//a:��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"Ԫ";
							String praise=praiseNums[j]+"��";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						
						//������ѡ��Ʒ�ı���Լ�����
						System.out.println("��ѡ���Ʒ��ţ�");
						int chooseDish=input.nextInt();
						System.out.println("��ѡ�������");
						int number=input.nextInt();
						//���ϲ�Ʒ����
						String dishMeg=dishNames[chooseDish-1]+" "+number+"��";
						
						//b:���붩��������
						System.out.println("�����붩����������");
						String name=input.next();
						
						//c:�����Ͳ�ʱ��
						System.out.println("�����붩��ʱ�䣨10~20�����Ͳͣ���");
						int time=input.nextInt();
						//�������ˣ��ظ�����
						while(time<10||time>20){
							System.out.println("�Բ���������������������10~20֮���������");
							time=input.nextInt();
						}
						
						//d:�����Ͳ͵�ַ
						System.out.println("�������Ͳ͵�ַ��");
						String address=input.next();
						
						//e:����ͷ�
						double sumPrice=prices[chooseDish-1]*number;
						//�Ͳͷѣ����ͷѴﵽ50Ԫʱ����6Ԫ�Ͳͷ�
						double deliCharge=(sumPrice >=50 ? 0 : 6 );
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("��������:"+dishMeg);
						System.out.println("������:"+name);
						System.out.println("�Ͳ�ʱ��:"+time+"��");
						System.out.println("�Ͳ͵�ַ:"+address);
						System.out.println("�ͷѣ�"+sumPrice+",�Ͳͷѣ�"+deliCharge+"Ԫ");
						System.out.println("�ܽ�"+(sumPrice+deliCharge)+"Ԫ");
						
						//��������
						names[i]=name;
						dishMegs[i]=dishMeg;
						times[i]=time;
						addresses[i]=address;
						sumPrices[i]=sumPrice+deliCharge;
						
						break;
					}
				}
				//û�ҵ�Ϊ�յ�λ�ã���ʾ��Ϣ
				if(!isAdd){
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
			case 2:
				//�鿴�ʹ�
				System.out.println("************�鿴�ʹ�************");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"��";
						String sumPrice=sumPrices[i]+"Ԫ";
						String state=states[i]==0 ? "��Ԥ��": "�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
					}
				}
				break;
			case 3:
				//ɾ������
				System.out.println("***************ɾ������***************");
				System.out.println("������Ҫɾ���Ķ������");
				int xuHao = input.nextInt();
				int delIndex=-1; //�ҵ���Ҫɾ���Ķ����±�
				boolean isDelFind=false;   //��¼�Ƿ��ҵ���������
				//�ҵ��˶���  
				for(int i=0;i<names.length;i++){
					//�ҵ��Ķ�����ǩ�գ���ɾ��
					if(names[i]!=null && states[i]==1 && xuHao==i+1){
						isDelFind=true;
						delIndex=i;
						break;
					}
					//�ҵ��Ķ���δǩ�գ�����ɾ��
					else if(names[i]!=null && states[i]==0 && xuHao==i+1){
						isDelFind=true;
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						break;
					}
				}
				//δ�ҵ���������
				if(!isDelFind){
					System.out.println("�Բ��𣬴������������ڡ�");
				}
				
				//ִ��ɾ������
				if(delIndex!=-1){
					//��Ҫɾ����Ԫ�غ���һ����ʼ�����������һ��Ԫ�أ�������ǰ�ƶ�һλ���������ݡ�
					for(int i=delIndex+1;i<names.length;i++){
						names[i-1]=names[i];
						dishMegs[i-1]=dishMegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
						prices[i-1]=prices[i];
						
					}
					//���һλ�������
					names[names.length-1]=null;
					dishMegs[dishMegs.length-1]=null;
					times[times.length-1]=0;
					addresses[addresses.length-1]=null;
					states[states.length-1]=0;
					//
					System.out.println("����ɾ���ɹ���");
				}
				break;
			case 4:
				//ǩ�ն���
				System.out.println("*************ǩ�ն���**************");
				System.out.println("������Ҫǩ�յĶ�����ţ�");
				int signOrderId=input.nextInt();
				boolean isFind=false;  //��¼�Ƿ��ҵ�������������false��û�ҵ���	true:�ҵ��ˡ�
				//������������(ѭ������)
				for(int i=0;i<names.length;i++){
					//1.�ҵ���״̬������ɣ��Ѿ�ǩ����ϣ�����ʾ�����ٴ�ǩ��
					//2.�ҵ���״̬����Ԥ����û�����ǩ�գ�������ǩ��
					if(names[i]!=null && states[i]==1 && signOrderId==i+1){
						System.out.println("�Բ�����ѡ��Ķ����Ѿ�ǩ�գ������ٴ�ǩ�ա�");
						isFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i]=1; //״ֵ̬��Ϊ�����״̬
						isFind=true;
						System.out.println("����ǩ�ճɹ���");
						break;
					}
				}
				
				//3.�Բ��𣬴˶���������
				//�����жϣ����û�ҵ�������������ȥ��ʾû���ҵ�
				if(!isFind){
					System.out.println("�Բ��𣬴˶��������ڡ�");
				}
				break;
			case 5:
				//��Ҫ����
				System.out.println("**************��Ҫ����*************");
				//1.��ʾ���пɹ����޵Ĳ�Ʒ��Ϣ
				System.out.println("���\t��Ʒ��\t����\t������");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"Ԫ";
					String praise=praiseNums[j]+"��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				//2.����Ҫ���޵Ĳ�Ʒ���
				System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishId=input.nextInt();
				//
				//3.����ŵĲ�Ʒ��������1
				praiseNums[dishId-1]++;
				
				//4.��ʾ
				System.out.println("���޳ɹ�!");
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"��");
				
				break;
			case 6:
				//�˳�ϵͳ
				break;
			default:
				//�������
				break;
			}
			//���û����빦�ܱ��Ϊ1~5֮�������ʱ���˳�ѭ�����������ʾ����0���ء�
			if(choose>5||choose<1){
				break;
			}
			
			//��ʾ����0����
			System.out.println("����0����:");
			num=input.nextInt();
			
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
		
	}
}
