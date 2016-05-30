package net.connie.LibreriaNumerologia;

public class Numerologia 
{
	public int NumerologyValue(String NameString)
	{
		// Auxiliary variable declaration
		int NameValue = 0;
		int[] Dig = new int[4];
		char[] ListN; // char array of all letters (including spaces)
		
		// Clean last name value
		NameValue = 0;
		
		// Convert substrings to char elements
		ListN = new char[NameString.length()];
		for (int i = 0; i < NameString.length(); i++)
		{
			ListN[i] = NameString.toUpperCase().charAt(i);
		}

		// Calculate the value of the whole string
		for (int i = 0; i < NameString.length(); i++)
		{
			NameValue += Numerologia.LetterValue(ListN[i]);
		}

		// Determine the NameValue if it is not 11 or 22
		switch (NameValue)
		{
			case 22:
				return NameValue;

			case 11:
				return NameValue;

			default:
				// Cycle if NameValue has 2 or more digits
				while (NameValue >= 10 && NameValue != 11
						&& NameValue != 22)
				{
					// Put digits in Dig array to sum them up
					for(int i = 0; i < Dig.length; i++)
					{
						Dig[i] = NameValue % 10;
						NameValue = (NameValue - Dig[i]) / 10;
					}

					// Clear old name value
					NameValue = 0;

					// New name value
					for (int c = 0; c < Dig.length; c++)
					{
						NameValue += Dig[c];
						Dig[c] = 0; // Clear digit value
					}
				}
				
				// Return NameValue
				return NameValue;
		}
	}
	
	// Subprogram that determines the value of each letter
	public static int LetterValue(char Letter)
	{
		switch (Letter)
		{
			case 'A': case 'a':
				return 1;

			case 'B': case 'b':
				return 2;

			case 'C': case 'c':
				return 3;

			case 'D': case 'd':
				return 4;

			case 'E': case 'e':
				return 5;

			case 'F': case 'f':
				return 6;

			case 'G': case 'g':
				return 7;

			case 'H': case 'h':
				return 8;

			case 'I': case 'i':
				return 9;

			case 'J': case 'j':
				return 1;

			case 'K': case 'k':
				return 2;

			case 'L': case 'l':
				return 3;

			case 'M': case 'm':
				return 4;

			case 'N': case 'n':
				return 5;

			case 'O': case 'o':
				return 6;

			case 'P': case 'p':
				return 7;

			case 'Q': case 'q':
				return 8;

			case 'R': case 'r':
				return 9;

			case 'S': case 's':
				return 1;

			case 'T': case 't':
				return 2;

			case 'U': case 'u':
				return 3;

			case 'V': case 'v':
				return 4;

			case 'W': case 'w':
				return 5;

			case 'X': case 'x':
				return 6;

			case 'Y': case 'y':
				return 7;

			case 'Z': case 'z':
				return 8;

			case ' ':
				return 0;

			case '\0':
				return 0;

			default:
				return 0;
		}
	}

	// Subprogram that prints personal description based on the name sum
	public static String Description(int NameNumber)
	{
		switch (NameNumber)
		{
			case 1:
				return "Initiating action, pioneering, leading, independent, attaining, individual.";

			case 2:
				return "Cooperation, adaptability, consideration of others, partnering, mediating.";

			case 3:
				return "Expression, verbalization, socialization, the arts, the joy of living.";

			case 4:
				return "A foundation, order, service, struggle against limits, steady growth.";

			case 5:
				return "Expansiveness, visionary, adventure, the constructive use of freedom.";

			case 6:
				return "Responsibility, protection, nurturing, community, balance, sympathy.";

			case 7:
				return "Analysis, understanding, knowledge, awareness, studious, meditating.";

			case 8:
				return "Practical endeavors, status oriented, power-seeking, high-material goals.";

			case 9:
				return "Humanitarian, giving nature, selflessness, obligations, creative expression.";

			case 11:
				return "Higher spiritual plane, intuitive, illumination, idealist, a dreamer.";

			case 22:
				return "The Master Builder, large endeavors, powerful force, leadership.";

			// In case of error
			default:
				return ":)";
		}
	}
}
