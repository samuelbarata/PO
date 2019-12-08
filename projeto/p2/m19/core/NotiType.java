package m19.core;

public enum NotiType{
	ENTREGA("ENTREGA"), REQUISIÇÃO("REQUISIÇÃO");

	private final String _text;

	private NotiType(String label){
		_text=label;
	}

	public String toSting(){
		return _text;
	}

}