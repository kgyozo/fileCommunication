package com.epam.gyozo_karer;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WriteOutObserver implements Observer {
	
	public void update(FileEvent event) {
		System.out.printf("Modosult a file (%s), kiolvassuk es kiirjuk", event.getFileName());
		if (ENTRY_MODIFY == event.getFileEvent()) {
			
		}

	}

}
