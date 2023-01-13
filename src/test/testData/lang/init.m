GetStandard[m_, n_, α_, x0_, y0_] := Block[
	{eqs, x, y, a, b, c, d, e, f, z},
	eqs = ((x - x0)Cos[α] + (y - y0)Sin[α])^2 / m^2 + ((y - y0)Cos[α] - (x - x0)Sin[α])^2 / n^2 - 1;
	{{f, e, c}, {d, b, z}, {a, z, z}} = CoefficientList[eqs, {x, y}];
	FullSimplify@{{a, b / 2, d / 2}, {b / 2, c, e / 2}, {d / 2, e / 2, f}}
];
GetNormal[A_, B_, C_, D_, E_, F_] := Block[
	{α, a, b, c, d, e, f},
	{a, b, c, d, e, f} = {A, B, C, D, E, F};
	α = If[a == c, Pi / 4, ArcTan[b / (a - c)] / 2];
	{a, c, d, e} = {
		a Cos[α]^2 + b Cos[α]Sin[α] + c Sin[α]^2,
		a Sin[α]^2 - b Cos[α]Sin[α] + c Cos[α]^2,
		e Sin[α] + d Cos[α],
		e Cos[α] - d Sin[α],
	};
	FullSimplify@{
		Sqrt[(c d^2 + a e^2 - 4f a c) / (4a^2 c)],
		Sqrt[(c d^2 + a e^2 - 4f a c) / (4a c^2)],
		α,
		-d / (2a),
		-e / (2c)
	}
];