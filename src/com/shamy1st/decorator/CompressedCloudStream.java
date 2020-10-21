package com.shamy1st.decorator;

public class CompressedCloudStream implements Stream {

	private Stream stream;
	
	public CompressedCloudStream(Stream stream) {
		this.stream = stream;
	}
	
	@Override
	public void write(String data) {
		String compressedData = compress(data);
		stream.write(compressedData);
	}
	
	private String compress(String data) {
		return "compressed-(" + data + ")";
	}
}
