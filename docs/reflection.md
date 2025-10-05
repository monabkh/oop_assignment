# Reflektion över projektet: Textbaserat äventyrsspel i Java

## Vad gick bra

En av de saker som gick bäst i projektet var att implementera objektorienterad programmering med arv och abstrakta klasser. Jag lyckades skapa en tydlig arvstruktur med en abstrakt `Character`-klass, och därifrån bygga vidare med `Hero`, `Monster`, `Goblin` och `Boss`. Jag förstod snabbt hur jag kunde dela upp logiken på ett logiskt sätt, där basklassen innehåller gemensamma egenskaper (som namn, hp och attackmetoder), medan de mer specifika klasserna fick sina egna egenskaper och beteenden.

Jag blev också nöjd med hur jag byggde menylogiken efter striderna. Jag lade till en enkel, tydlig huvudmeny där användaren kunde visa hjältestatus, gå till affären eller avsluta spelet. Spelet blev lätt att följa, vilket gjorde det roligt att testa och felsöka.

## Utmaningar

En stor utmaning var att förstå hur abstrakta metoder fungerar i praktiken. Först fick jag felmeddelanden som "cannot find symbol" när jag försökte anropa metoder från en abstrakt klass innan de var implementerade i subklasserna. Det tog tid att förstå att jag inte kunde skapa objekt av abstrakta klasser och att alla abstrakta metoder måste överskridas i de konkreta klasserna. Jag löste detta genom att gå tillbaka till grunderna och testa små kodexempel i isolering.

En annan utmaning var att implementera shoppen. Det var inte helt självklart hur man skulle använda ett interface (`Purchasable`) och koppla ihop det med en `Shop`-klass som kunde hantera olika typer av köpbara objekt. Jag löste det genom att först bygga en enklare version med bara en `HealthPotion`, och sedan utöka med fler items.

## Reflektion kring inlärda koncept

Genom projektet har jag lärt mig mycket om objektorienterad design i Java. Jag förstår nu skillnaden mellan abstrakta klasser och interface, och varför man använder dem. Jag har också tränat på inkapsling (private/protected/public), arv, och polymorfism.

Dessutom har jag fått träning i att strukturera kod i flera filer och paket, vilket känns mer professionellt än att skriva all kod i en enda fil. Att skriva ett turbaserat spel har också hjälpt mig att tänka mer i steg och flöden, vilket kommer vara användbart i framtida programmeringsprojekt.

Jag är stolt över att jag lyckades få alla delar av spelet att fungera, inklusive leveling, strid, affär, meny och vinstvillkor. Jag känner att jag har vuxit som programmerare under detta projekt.
