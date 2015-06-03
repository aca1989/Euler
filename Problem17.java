// Number letter counts
// If all numbers from 1 to 1000 (one thousand) inclusive were 
// written out in words, how many letters would be used?

public class Problem17
{
	private static int totalNumberOfLetters = 0;

	public static void main(String args[])
	{
		long start = System.currentTimeMillis();

		for(int number = 1; number <= 1000; number++)
		{
			//totalNumberOfLetters += intToLetters(number);
			int temp = intToLetters(number);
			System.out.println(number + ") " + temp);
			totalNumberOfLetters += temp;
		}

		System.out.println("Total number of letters: " + totalNumberOfLetters);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}

	// Returns the number of letters in the number num
	public static int intToLetters(int num)
	{
		int letters = 0;
		int thousands = 0, hundreds = 0, tens = 0, ones = 0;
		boolean isThousand = false, isHundred = false, isTen = false;	// Flags for various values

		// Extracts the digits from the number
		ones = num % 10;
		num /= 10;
		tens = num % 10;
		num /= 10;
		hundreds = num % 10;
		num /= 10;
		thousands = num % 10;

		// Sets flags for various numbers
		if(thousands > 0)
			isThousand = true;
		if(hundreds > 0)
			isHundred = true;
		if(tens > 0)
			isTen = true;
		
		// Count letters
		if(isThousand)
		{
			letters += 11;								// one thousand
		}
		else
		{
			if(isHundred)
			{
				switch(hundreds)
				{
					case 1:
						letters += 3;					// one
						break;
					case 2:
						letters += 3;					// two
						break;
					case 3:
						letters += 5;					// three
						break;
					case 4:
						letters += 4;					// four
						break;
					case 5:
						letters += 4;					// five
						break;
					case 6:
						letters += 3;					// six
						break;
					case 7:
						letters += 5;					// seven
						break;
					case 8:
						letters += 5;					// eight
						break;
					case 9:
						letters += 4;					// nine
						break;
				}

				letters += 7;							// hundred
			}
			
			if(isHundred && (tens > 0 || ones > 0))
				letters += 3;							// and

			if(isTen)
			{
				switch(tens)
				{
					case 1:
						switch(ones)
						{
							case 0:
								letters += 3;				// ten
								break;
							case 1:
								letters += 6;				// eleven
								break;
							case 2:
								letters += 6;				// twelve
								break;
							case 3:
								letters += 8;				// thirteen
								break;
							case 4:
								letters += 8;				// fourteen
								break;
							case 5:
								letters += 7;				// fifteen
								break;
							case 6:
								letters += 7;				// sixteen
								break;
							case 7:
								letters += 9;				// seventeen
								break;
							case 8:
								letters += 8;				// eighteen
								break;
							case 9:
								letters += 8;				// nineteen
								break;
						}
						break;
					case 2:
						letters += 6;						// twenty
						break;
					case 3:
						letters += 6;						// thirty
						break;
					case 4:
						letters += 5;						// forty
						break;
					case 5:
						letters += 5;						// fifty
						break;
					case 6:
						letters += 5;						// sixty
						break;
					case 7:
						letters += 7;						// seventy
						break;
					case 8:
						letters += 6;						// eighty
						break;
					case 9:
						letters += 6;						// ninety
						break;
				}
			}
			
			if(tens != 1)
			{
				switch(ones)
				{
					case 0:								// nothing
						break;
					case 1:
						letters += 3;					// one
						break;
					case 2:
						letters += 3;					// two
						break;
					case 3:
						letters += 5;					// three
						break;
					case 4:
						letters += 4;					// four
						break;
					case 5:
						letters += 4;					// five
						break;
					case 6:
						letters += 3;					// six
						break;
					case 7:
						letters += 5;					// seven
						break;
					case 8:
						letters += 5;					// eight
						break;
					case 9:
						letters += 4;					// nine
						break;
				}
			}
		}

		return letters;
	}
}