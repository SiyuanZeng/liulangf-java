/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.pattern.gof.creational.builder.house;

/**
 *
 * @author Quqing Liu
 */
public abstract class HouseBuilder {
	protected House house;
	protected Floor floor;
	protected Walls walls;
	protected Roof roof;
	protected abstract House createHouse();
	protected abstract Floor createFloor();
	protected abstract Walls createWalls();
	protected abstract Roof createRoof();

}
