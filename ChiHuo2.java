import java.util.Scanner;

//

public class ChiHuo2 {
	public static void main(String[] args) {
		////�������� ������Ϣ
			//�Ͳ���
			String[] names=new String[4];
			//��Ʒ��Ϣ(���� ����)
			String[] canPinXinXis=new String[4];
			//�Ͳ�ʱ��
			int[] shiJians=new int[4];
			//�Ͳ͵�ַ
			String[] diZhis=new String[4];
			//����״̬ 1����Ԥ�� 0�������
			int[] zTs=new int[4];
			//������Ʒ�ܽ��
			double[] $zongs=new double[4];
			
			//��ʼ������������Ϣ
			names[0]="���Ѽ�";
			canPinXinXis[0]="������˿1��";
			shiJians[0]=12;
			diZhis[0]="�������999��";
			zTs[0]=0;
			$zongs[0]=26.0;
			//
			names[1]="���Ѽ�";
			canPinXinXis[1]="���մ���2��";
			shiJians[1]=13;
			diZhis[1]="�Ϻ������888��";
			zTs[1]=1;
			$zongs[1]=60.0;
			//
		////�������� �˵���Ϣ
			//��Ʒ��
			String[] canPinnames={"������˿","���մ���","ʱ���߲�"};
			//����
			double[] $danJias={20.0, 30.0, 10.0 };
			//������
			int[] dianZans=new int[3];
		/////////////////////////////////////
			//////������
			Scanner input=new Scanner(System.in);
			//�û���������0ѭ��
			int yongHu=-1;
			//���������ж��˳�ϵͳ
			boolean tuiChu=false;
			//
			do{
				//��ʾ���˵�
				System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
				System.out.println("********************���˵�********************");
				System.out.println("1.��Ҫ����");
				System.out.println("2.�鿴�ʹ�");
				System.out.println("3.ǩ�ն���");
				System.out.println("4.ɾ������");
				System.out.println("5.��Ҫ����");
				System.out.println("6.�˳�ϵͳ");
				System.out.println("*********************************************");
				System.out.println("��ѡ��");
				int xuHao=input.nextInt();
				//�û�ѡ����Ź���
				switch(xuHao){
				case 1:
					//��Ҫ����
					System.out.println("***************��Ҫ����****************");
					//��¼��λ���±꣨����������һ�µģ�
					int kong=-1;
					//���ҿ�λ��
					for(int i=0;i<names.length;i++){
						if(names[i]==null){
							kong=i;
							//�ҵ���λ�ú�ѭ����������ʾ�˵�,   �ṩ�û�ѡ�񣺲�Ʒ���࣬������
							System.out.println("���\t����\t����\t������");
							for(int j=0;j<canPinnames.length;j++){
								System.out.println((j+1)+"\t"+canPinnames[j]+"\t"+$danJias[j]+"Ԫ"+"\t"+dianZans[j]+"��");
							}
					//�û�����д��
							//�����Ʒ��Ϣ
							System.out.println("�������Ʒ��ţ�");
							int bianHao=input.nextInt();
							System.out.println("�����������");
							int fengShu=input.nextInt();
							//���ϲ�Ʒ��Ϣ
							String canPinXinXi=canPinnames[bianHao-1]+fengShu+"��";
							//��������
							System.out.println("������������");
							String name=input.next();
							//����ʱ�䣬��������������
							System.out.println("�������Ͳ�ʱ��(10~20֮�������)��");
							int shiJian=input.nextInt();
							while(shiJian>20||shiJian<10){
								System.out.println("����������������Ͳ�ʱ��(10~20֮�������)��");
								shiJian=input.nextInt();
							}
							//
							System.out.println("�������ַ��");
							String diZhi=input.next();
							//�����Ʒ���
							double $zong=$danJias[bianHao-1]*fengShu;
							//�Ͳͷ�    ��Ʒ�ܽ�����30���Ż�6Ԫ�Ͳͷ�
							double songCan=($zong>30) ? 0.0 : 6.0;
							//��ʾ������Ϣ
							System.out.println("***************���ͳɹ������Ķ�������***************");
							System.out.println("��������:"+canPinXinXi);
							System.out.println("�����ˣ�"+name);
							System.out.println("�Ͳ�ʱ�䣺"+shiJian+"��");
							System.out.println("�Ͳ͵�ַ��"+diZhi);
							System.out.println("��Ʒ�ܽ�"+$zong+"Ԫ;\t�Ͳͷѣ�"+songCan+"Ԫ");
							System.out.println("�����ܽ�"+($zong+songCan)+"Ԫ");
					//¼�붩������
							//�Ͳ���
							names[i]=name;
							//��Ʒ��Ϣ(���� ����)
							canPinXinXis[i]=canPinXinXi;
							//�Ͳ�ʱ��
							shiJians[i]=shiJian;
							//�Ͳ͵�ַ
							diZhis[i]=diZhi;
							//����״̬ 1����Ԥ�� 0�������
							zTs[i]=1;
							//������Ʒ�ܽ��
							$zongs[i]=$zong+songCan;
							break;
						}
					}
					//û���ҵ���λ��ʱ kongֵ���䣬��ʾ��Ϣ���ʹ�������
					if(kong==-1){
						System.out.println("�Բ��𣬲ʹ�������");
					}
					//
					break;
				case 2:
					//�鿴�ʹ�
					System.out.println("*****************�鿴�ʹ�****************");
					System.out.println("���\t����\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t��Ʒ���\t����״̬");
					//ѭ�������������
					for(int i=0;i<names.length;i++){
						//����ʹ�����
						if(names[i]!=null){
						String zT=(zTs[i]==0) ? "�����":"��Ԥ��";//����ת�����ֱ�ʾ����״̬
						System.out.println((i+1)+"\t"+names[i]+"\t"+canPinXinXis[i]+"\t"+shiJians[i]+"��"+"\t"+diZhis[i]+"\t"+$zongs[i]+"Ԫ"+"\t"+zT);
						}
					}
					break;
				case 3:
					//ǩ�ն���
					System.out.println("********************ǩ�ն���*********************");
					//�����ǰ����Ŀ¼(ֱ�ӿ��ʹ�)
					System.out.println("���\t����\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t��Ʒ���\t����״̬");
					//ѭ�������������
					for(int i=0;i<names.length;i++){
						//����ʹ�����
						if(names[i]!=null){
						String zT=(zTs[i]==0) ? "�����":"��Ԥ��";//����ת�����ֱ�ʾ����״̬
						System.out.println((i+1)+"\t"+names[i]+"\t"+canPinXinXis[i]+"\t"+shiJians[i]+"��"+"\t"+diZhis[i]+"\t"+$zongs[i]+"Ԫ"+"\t"+zT);
						}
					}
					System.out.println("��ѡ��Ҫǩ�յĶ�����");
					int qianShou=input.nextInt();
					//�ж϶�����Ϊ��   //��������ϢΪ�жϣ�������ϢҲ��һ��
					//�����ж϶���δǩ��  �����ǩ��
					if(names[qianShou-1]!=null && zTs[qianShou-1]==1){
						zTs[qianShou-1]=0;
						System.out.println("ǩ����ɣ�");
					}
					//������Ϊ�գ����������ǩ�գ�����ʾ��Ϣ�Ѿ���ɹ�
					else if(names[qianShou-1]!=null && zTs[qianShou-1]==0){
						System.out.println("�˶�����ǩ�գ�������ǩ�ա�");
					}else{
						System.out.println("�˶��������ڣ�");
						
					}
					break;
				case 4:
					//ɾ������
					System.out.println("******************ɾ������****************");
					//�����ǰ����Ŀ¼(ֱ�ӿ��ʹ�)
					System.out.println("���\t����\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t��Ʒ���\t����״̬");
					//ѭ�������������
					for(int i=0;i<names.length;i++){
						//����ʹ�����
						if(names[i]!=null){
						String zT=(zTs[i]==0) ? "�����":"��Ԥ��";//����ת�����ֱ�ʾ����״̬
						System.out.println((i+1)+"\t"+names[i]+"\t"+canPinXinXis[i]+"\t"+shiJians[i]+"��"+"\t"+diZhis[i]+"\t"+$zongs[i]+"Ԫ"+"\t"+zT);
						}
					}
					//ѡ�����
					System.out.println("��ѡ��Ҫɾ���Ķ�����");
					int shanChu=input.nextInt();
					//�ҵ��ı��
					boolean zhaoDao=false;  //true�ҵ���     //falseû�ҵ�
					//ѭ�������ҵ������ŵĶ���
					//�ö�������ɲ���ɾ��
					for(int j=0;j<names.length;j++){
						if(j==shanChu-1 && names[j]!=null && zTs[j]==0){
							zhaoDao=true; //�ҵ���
							//��Ҫɾ����������Ķ������ݸ���ǰ��ģ�ѭ�����θ�����λ��
							//���һλ�����б����ǲ��������򸲸����һλ��λԽ�硣
							//���һλ��ֵ����գ�������ѭ��Ҳ��Ӱ�������
							for(int i=j;i<names.length-1;i++){
								names[i]=names[i+1];
								canPinXinXis[i]=canPinXinXis[i+1];
								shiJians[i]=shiJians[i+1];
								diZhis[i]=diZhis[i+1];
								zTs[i]=zTs[i+1];
								$zongs[i]=$zongs[i+1];
							}
							//������һ���������ݣ��ڳ���λ�����㶩��û�������˲���Ҳ����Ӱ��
							names[names.length-1]=null;
							canPinXinXis[canPinXinXis.length-1]=null;
							shiJians[shiJians.length-1]=0;
							diZhis[diZhis.length-1]=null;
							zTs[zTs.length-1]=0;
							$zongs[$zongs.length-1]=0.0;
							System.out.println("����ɾ���ɹ���");
							break;
						}else if(j==shanChu-1 && names[j]!=null && zTs[j]==1){
							zhaoDao=true; //�ҵ���
							System.out.println("�ö���δ��ɣ�����ɾ����");
							break;
						}
					}
					//û�ҵ�����ʾ�ö���������
					if(!zhaoDao){
						System.out.println("�ö��������ڣ�");
					}
					
					break;
				case 5:
					//��Ҫ����
					boolean panduan=false;
					System.out.println("*****************Ŀǰ�˵��ȶ�***************");
					System.out.println("���\t����\t����\t������");
					for(int j=0;j<canPinnames.length;j++){
						System.out.println((j+1)+"\t"+canPinnames[j]+"\t"+$danJias[j]+"Ԫ"+"\t"+dianZans[j]+"��");
					}
					System.out.println("��ѡ����޲�Ʒ��ţ�");
					int dianZan=input.nextInt();
					//ѭ�������ҵ���Ʒ����
					for(int i=0;i<canPinnames.length;i++){
						if(i==dianZan-1){
							//��������1
							panduan=true;
							dianZans[i]++;
							System.out.println("���޳ɹ���");
							System.out.println(canPinnames[i]+" "+dianZans[i]+"��");
							break;
						}
					}
					if(!panduan){
						System.out.println("������Ŵ���");
					}
					
					break;
				case 6:
					tuiChu=true;
					//�˳�ϵͳ
					break;
				default:
					tuiChu=true;
					//
					break;
				}
				if(tuiChu){
					break;
				}
				System.out.println("������0����");
				yongHu=input.nextInt();
			}while(yongHu==0);
			
			System.out.println("ллʹ�ã���ӭ������");
			
	}
}
