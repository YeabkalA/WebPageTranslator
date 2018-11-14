import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class HTMLParserTool {

	private String url;
	private String tempFile;
	private String destFile;
	private String sourceCode;
	
	public HTMLParserTool(String url,
			String tempFile,
			String destFile) {
		this.url = url;
		this.tempFile = tempFile;
		this.destFile = destFile;
	}

	public void convert(String txt, String dest) throws Exception {
		Translator translator = new Translator();
		PrintWriter writer = new PrintWriter(dest);
		int ind = 1;
		StringBuilder toTrans = new StringBuilder();
		StringBuilder code = new StringBuilder("<");
		int state = 1;
		while(ind < txt.length()) {
			char current = txt.charAt(ind);
			if(current == '<') {
				String textToTranslate = toTrans.toString();
				if(!textToTranslate.trim().equals("")) {
					String translatedString = translator.translate(textToTranslate);
					code.append(translatedString);
				}
				code.append("\n<");
				toTrans = new StringBuilder();
				state++;
			} else if (current == '>') {
				code.append(current);
				state--;
			} else {
				if (state == 0) {
					toTrans.append(current);
				} else {
					code.append(current);
				}
			}
			ind++;
		}
		writer.print(code.toString());
		writer.close();
	}
	
	public void run() throws Exception {
		FileExtractor extractor = new FileExtractor(tempFile);
		SourceCodeFetcher fetcher = new SourceCodeFetcher(url, tempFile);
		
		fetcher.saveSourceCodeToFile();
		sourceCode = extractor.readFile(tempFile);
		convert(sourceCode, destFile);
	}

	public static void main(String[] args) throws Exception {
		new HTMLParserTool("https://projecteuler.net/archives", "temp", "new22.html").run();
	}
}