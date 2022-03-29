# HTTP-Java-app

**Java aplikacija koja sadrzi glavni server koji je zaduzan da handluje POST i GET requestove klijenta (browser).**  
Glavni server je zaduzen da kada dobije GET zahtev renderuje staticku stranicu.  
POST zahtev treba da primi parametre iz forme na /save-quote i sacuva ih.  
Glavni servis takodje ima i komunikaciju sa pomocnim servisom koji takodje prima HTTP zahtev (GET) i jedina funckionalnost je da vraca Quote of The Day u JSON formatu.
