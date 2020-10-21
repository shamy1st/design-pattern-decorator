package com.shamy1st;

import com.shamy1st.decorator.CloudStream;
import com.shamy1st.decorator.CompressedCloudStream;
import com.shamy1st.decorator.EncryptedCloudStream;
import com.shamy1st.decorator.Stream;

public class Main {

	public static void main(String[] args) {
		
		//1. Encrypt
		//2. Compress
		//3. Write
		Stream stream = new EncryptedCloudStream(
						new CompressedCloudStream(
						new CloudStream()));
		storeCreditCard(stream);
	}
	
	//this method doesn't depend on the order of operations
	public static void storeCreditCard(Stream stream) {
		stream.write("1234-1234-1234-1234");
	}

}
