package com.xaoilin.GameObjects;

import java.util.concurrent.atomic.AtomicInteger;

import com.badlogic.gdx.math.Rectangle;
import com.xaoilin.GameWorld.Helper;

public class Snowflake {
	// RECTANGLES
	public float width, height, rectX, rectY;
	public Rectangle rectBounds = new Rectangle();

	// SNOWFLAKE
	final int ARRAYSIZE = 168;
	public float[] verticesPoly = new float[ARRAYSIZE];
	public short[] indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
	public int once = 0;
	public double speed, rotation, color, pulsating;
	public float singleRotation;
	public float originX, originY;

	static AtomicInteger nextId = new AtomicInteger();
	public int id;

	public Snowflake() {
		if(nextId.get() == Shapes.SHAPES_SIZE){
			nextId.set(1);
			id = nextId.get();
		}else{
			id = nextId.incrementAndGet();
		}
	}

	public void resetVariables() {
		this.verticesPoly = new float[ARRAYSIZE];
		this.originX = 0;
		this.originY = 0;
		this.speed = 0;
		this.rotation = 0;
		this.color = 0;
		this.pulsating = 0;
		this.once = 0;
		this.singleRotation = 0;
	}

	public void snowflake(int x, int y, float w, float h, double rotation, double s, double color, double puls, float singleRotation) {

		if (once == 0) {
			System.out.println("Snowflake entered");

			// SET RECTANGLE BOUNDS
			this.rectX = x;
			this.rectY = y;
			this.width = w;
			this.height = h;

			// Rotation Purposes
			originX = x;
			originY = y;

			// SET 168 POINTS
			float[] verticies = { x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x,
					y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y,
					x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x,
					y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y,
					x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x, y, x,
					y, x, y, x, y, x, y, };

			this.verticesPoly = verticies;

			this.speed = s;
			this.rotation = rotation;
			this.color = color;
			this.pulsating = puls;
			this.singleRotation = singleRotation;

			once++;
		}

		rectX -= speed;
		rectY -= speed;
		width += speed * 2;
		height += speed * 2;

		poly();
		// Update Indices once after grow()
		if (once < 10) {
			indices = Helper.earclip.computeTriangles(verticesPoly).toArray();
			once++;
		}
	}

	public void poly() {

		// Top Tip 1
		verticesPoly[0] -= speed * 0.03; // go left X
		verticesPoly[1] -= speed * 0.90; // go up Y

		verticesPoly[2] += speed * 0.08; // go right X
		verticesPoly[3] -= speed * 0.85; // go up Y

		verticesPoly[4] += speed * 0.10; // go left X
		verticesPoly[5] -= speed * 0.66; // go up Y

		// Top Tip 2
		verticesPoly[6] += speed * 0.27; // go right X
		verticesPoly[7] -= speed * 0.755; // go up Y

		verticesPoly[8] += speed * 0.39; // go left X
		verticesPoly[9] -= speed * 0.72; // go up Y

		verticesPoly[10] += speed * 0.37; // go right X
		verticesPoly[11] -= speed * 0.62; // go up Y

		verticesPoly[12] += speed * 0.10; // go left X
		verticesPoly[13] -= speed * 0.48; // go up Y

		// Indent Top 1
		verticesPoly[14] += speed * 0.109; // go right X
		verticesPoly[15] -= speed * 0.163; // go up Y

		// Top Right Tip 1
		verticesPoly[16] += speed * 0.405; // go left X
		verticesPoly[17] -= speed * 0.323; // go up Y

		verticesPoly[18] += speed * 0.405; // go right X
		verticesPoly[19] -= speed * 0.615; // go up Y

		verticesPoly[20] += speed * 0.48; // go left X
		verticesPoly[21] -= speed * 0.67; // go up Y

		verticesPoly[22] += speed * 0.575; // go right X
		verticesPoly[23] -= speed * 0.625; // go up Y

		// Top Right Tip 2
		verticesPoly[24] += speed * 0.59; // go left X
		verticesPoly[25] -= speed * 0.415; // go up Y

		verticesPoly[26] += speed * 0.77; // go right X
		verticesPoly[27] -= speed * 0.52; // go up Y

		verticesPoly[28] += speed * 0.885; // go left X
		verticesPoly[29] -= speed * 0.495; // go up Y

		verticesPoly[30] += speed * 0.893; // go right X
		verticesPoly[31] -= speed * 0.35; // go up Y

		// Top Right Tip 3
		verticesPoly[32] += speed * 0.715; // go left X
		verticesPoly[33] -= speed * 0.242; // go up Y

		verticesPoly[34] += speed * 0.905; // go right X
		verticesPoly[35] -= speed * 0.145; // go up Y

		verticesPoly[36] += speed * 0.917; // go left X
		verticesPoly[37] -= speed * 0.055; // go up Y

		verticesPoly[38] += speed * 0.807; // go right X
		verticesPoly[39] -= speed * 0.015; // go up Y

		verticesPoly[40] += speed * 0.53; // go left X
		verticesPoly[41] -= speed * 0.145; // go up Y

		// Right Indent 2
		verticesPoly[42] += speed * 0.228; // go right X
		verticesPoly[43] += speed * 0.015; // go up Y

		// Bottom Right Tip 1
		verticesPoly[44] += speed * 0.54; // go left X
		verticesPoly[45] += speed * 0.17; // go up Y

		verticesPoly[46] += speed * 0.825; // go right X
		verticesPoly[47] += speed * 0.01; // go up Y

		verticesPoly[48] += speed * 0.915; // go left X
		verticesPoly[49] += speed * 0.05; // go up Y

		verticesPoly[50] += speed * 0.92; // go right X
		verticesPoly[51] += speed * 0.14; // go up Y

		// Bottom Right Tip 2
		verticesPoly[52] += speed * 0.725; // go left X
		verticesPoly[53] += speed * 0.265; // go up Y

		verticesPoly[54] += speed * 0.895; // go right X
		verticesPoly[55] += speed * 0.358; // go up Y

		verticesPoly[56] += speed * 0.91; // go left X
		verticesPoly[57] += speed * 0.455; // go up Y

		verticesPoly[58] += speed * 0.795; // go right X
		verticesPoly[59] += speed * 0.52; // go up Y

		// Bottom Right Tip 3
		verticesPoly[60] += speed * 0.613; // go left X
		verticesPoly[61] += speed * 0.445; // go up Y

		verticesPoly[62] += speed * 0.62; // go right X
		verticesPoly[63] += speed * 0.625; // go up Y

		verticesPoly[64] += speed * 0.53; // go left X
		verticesPoly[65] += speed * 0.700; // go up Y

		verticesPoly[66] += speed * 0.435; // go right X
		verticesPoly[67] += speed * 0.63; // go up Y

		verticesPoly[68] += speed * 0.425; // go left X
		verticesPoly[69] += speed * 0.355; // go up Y

		// Bottom Right Indent 3
		verticesPoly[70] += speed * 0.11; // go right X
		verticesPoly[71] += speed * 0.2; // go up Y

		// Bottom Tip 1
		verticesPoly[72] += speed * 0.12; // go left X
		verticesPoly[73] += speed * 0.52; // go up Y

		verticesPoly[74] += speed * 0.40; // go right X
		verticesPoly[75] += speed * 0.66; // go up Y

		verticesPoly[76] += speed * 0.45; // go left X
		verticesPoly[77] += speed * 0.75; // go up Y

		verticesPoly[78] += speed * 0.35; // go right X
		verticesPoly[79] += speed * 0.81; // go up Y

		// Bottom Tip 2
		verticesPoly[80] += speed * 0.125; // go left X
		verticesPoly[81] += speed * 0.705; // go up Y

		verticesPoly[82] += speed * 0.12; // go right X
		verticesPoly[83] += speed * 0.878; // go up Y

		verticesPoly[84] += speed * 0.015; // go left X
		verticesPoly[85] += speed * 0.95; // go up Y

		verticesPoly[86] -= speed * 0.10; // go right X
		verticesPoly[87] += speed * 0.888; // go up Y

		// Bottom Tip 3
		verticesPoly[88] -= speed * 0.11; // go left X
		verticesPoly[89] += speed * 0.72; // go up Y

		verticesPoly[90] -= speed * 0.29; // go right X
		verticesPoly[91] += speed * 0.81; // go up Y

		verticesPoly[92] -= speed * 0.395; // go left X
		verticesPoly[93] += speed * 0.775; // go up Y

		verticesPoly[94] -= speed * 0.375; // go right X
		verticesPoly[95] += speed * 0.66; // go up Y

		verticesPoly[96] -= speed * 0.12; // go left X
		verticesPoly[97] += speed * 0.52; // go up Y

		// Bottom Left Indent 4
		verticesPoly[98] -= speed * 0.13; // go right X
		verticesPoly[99] += speed * 0.21; // go up Y

		// Bottom Left Tip 1
		verticesPoly[100] -= speed * 0.43; // go left X
		verticesPoly[101] += speed * 0.37; // go up Y

		verticesPoly[102] -= speed * 0.42; // go right X
		verticesPoly[103] += speed * 0.66; // go up Y

		verticesPoly[104] -= speed * 0.506; // go left X
		verticesPoly[105] += speed * 0.720; // go up Y

		verticesPoly[106] -= speed * 0.595; // go right X
		verticesPoly[107] += speed * 0.675; // go up Y

		// Bottom Left Tip 2
		verticesPoly[108] -= speed * 0.61; // go left X
		verticesPoly[109] += speed * 0.455; // go up Y

		verticesPoly[110] -= speed * 0.785; // go right X
		verticesPoly[111] += speed * 0.55; // go up Y

		verticesPoly[112] -= speed * 0.915; // go left X
		verticesPoly[113] += speed * 0.505; // go up Y

		verticesPoly[114] -= speed * 0.905; // go right X
		verticesPoly[115] += speed * 0.395; // go up Y

		// Bottom Left Tip 3
		verticesPoly[116] -= speed * 0.72; // go left X
		verticesPoly[117] += speed * 0.27; // go up Y

		verticesPoly[118] -= speed * 0.9; // go right X
		verticesPoly[119] += speed * 0.2; // go up Y

		verticesPoly[120] -= speed * 0.95; // go left X
		verticesPoly[121] += speed * 0.1; // go up Y

		verticesPoly[122] -= speed * 0.835; // go right X
		verticesPoly[123] += speed * 0.065; // go up Y

		verticesPoly[124] -= speed * 0.55; // go left X
		verticesPoly[125] += speed * 0.18; // go up Y

		// Left Indent 5
		verticesPoly[126] -= speed * 0.25; // go right X
		verticesPoly[127] += speed * 0.025; // go up Y

		// Top Left Tip 1
		verticesPoly[128] -= speed * 0.55; // go left X
		verticesPoly[129] -= speed * 0.12; // go up Y

		verticesPoly[130] -= speed * 0.85; // go right X
		verticesPoly[131] += speed * 0.025; // go up Y

		verticesPoly[132] -= speed * 0.94; // go left X
		verticesPoly[133] -= speed * 0.01; // go up Y

		verticesPoly[134] -= speed * 0.94; // go right X
		verticesPoly[135] -= speed * 0.095; // go up Y

		// Top Left Tip 2
		verticesPoly[136] -= speed * 0.75; // go left X
		verticesPoly[137] -= speed * 0.21; // go up Y

		verticesPoly[138] -= speed * 0.92; // go right X
		verticesPoly[139] -= speed * 0.31; // go up Y

		verticesPoly[140] -= speed * 0.94; // go left X
		verticesPoly[141] -= speed * 0.43; // go up Y

		verticesPoly[142] -= speed * 0.825; // go right X
		verticesPoly[143] -= speed * 0.47; // go up Y

		// Top Left Tip 3
		verticesPoly[144] -= speed * 0.635; // go left X
		verticesPoly[145] -= speed * 0.39; // go up Y

		verticesPoly[146] -= speed * 0.64; // go right X
		verticesPoly[147] -= speed * 0.58; // go up Y

		verticesPoly[148] -= speed * 0.545; // go left X
		verticesPoly[149] -= speed * 0.65; // go up Y

		verticesPoly[150] -= speed * 0.45; // go right X
		verticesPoly[151] -= speed * 0.58; // go up Y

		verticesPoly[152] -= speed * 0.44; // go left X
		verticesPoly[153] -= speed * 0.3; // go up Y

		// Top Left Indent 6
		verticesPoly[154] -= speed * 0.135; // go right X
		verticesPoly[155] -= speed * 0.163; // go up Y

		// Top Tip 1
		verticesPoly[156] -= speed * 0.14; // go left X
		verticesPoly[157] -= speed * 0.465; // go up Y

		verticesPoly[158] -= speed * 0.435; // go right X
		verticesPoly[159] -= speed * 0.61; // go up Y

		verticesPoly[160] -= speed * 0.46; // go left X
		verticesPoly[161] -= speed * 0.7; // go up Y

		verticesPoly[162] -= speed * 0.36; // go right X
		verticesPoly[163] -= speed * 0.75; // go up Y

		// Top Tip 2
		verticesPoly[164] -= speed * 0.14; // go left X
		verticesPoly[165] -= speed * 0.655; // go up Y

		verticesPoly[166] -= speed * 0.14; // go right X
		verticesPoly[167] -= speed * 0.835; // go up Y

	}
}
