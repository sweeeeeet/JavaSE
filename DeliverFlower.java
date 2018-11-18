public class DeliverFlower{
	public static void main(String[] args){
		BfDeliverFlower bfFlower =new BfDeliverFlower("吕秀才","郭芙蓉");
		
		ProxyDeliverFlower proxy=new ProxyDeliverFlower(bfFlower);
		proxy.deliverFlower();
		
	}
}

//定义接口
interface Flower{
void deliverFlower();
}

//业务类
class BfDeliverFlower implements Flower{
	private String girlFriendName;
	private String boyFriendName;
	
	public BfDeliverFlower(String boyFriendName,String girlFriendName){
		this.boyFriendName=boyFriendName;
		this.girlFriendName=girlFriendName;
	}
	
	public void buyFlower(){
		System.out.println("男朋友"+boyFriendName+"买到了花");
	}
	public void deliverFlower(){
	
		System.out.println("男朋友"+boyFriendName+"把花送给了女朋友"+girlFriendName);
	}
	public void reserveFlower(){
		System.out.println("女朋友"+girlFriendName+"收到了男朋友"+boyFriendName+"的花");
	}
}
class ProxyDeliverFlower{
	
	private final BfDeliverFlower target;
	public ProxyDeliverFlower(BfDeliverFlower target){
		this.target=target;
	}
		
	public void postFlower(){
		System.out.println("男朋友把花托付给了快递员");
	}
	public void deliverFlower(){
		target.buyFlower();
		this.postFlower();
		System.out.println("快递员将花送给了女朋友");
		target.reserveFlower();
	}
	
}