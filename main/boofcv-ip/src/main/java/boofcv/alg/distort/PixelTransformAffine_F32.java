/*
 * Copyright (c) 2011-2019, Peter Abeles. All Rights Reserved.
 *
 * This file is part of BoofCV (http://boofcv.org).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package boofcv.alg.distort;

import boofcv.struct.distort.PixelTransform;
import georegression.struct.affine.Affine2D_F32;
import georegression.struct.point.Point2D_F32;
import georegression.transform.affine.AffinePointOps_F32;


/**
 * Distorts pixels using {@link Affine2D_F32}.
 *
 * @author Peter Abeles
 */
public class PixelTransformAffine_F32 implements PixelTransform<Point2D_F32> {

	Affine2D_F32 affine = new Affine2D_F32();

	public PixelTransformAffine_F32() {
	}

	public PixelTransformAffine_F32(Affine2D_F32 affine) {
		
		this.affine = affine;
	}

	public void set( Affine2D_F32 affine ) {
		this.affine.set(affine);
	}

	@Override
	public void compute(int x, int y, Point2D_F32 output) {
		AffinePointOps_F32.transform(affine, x, y, output);
	}

	public Affine2D_F32 getModel() {
		return affine;
	}

	@Override
	public PixelTransformAffine_F32 copy() {
		return new PixelTransformAffine_F32(affine.copy());
	}
}
