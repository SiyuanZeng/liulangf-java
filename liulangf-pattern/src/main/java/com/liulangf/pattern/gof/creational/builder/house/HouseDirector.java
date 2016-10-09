package com.liulangf.pattern.gof.creational.builder.house;

/**
 *
 * @author Quqing Liu
 */
public class HouseDirector {
	
	public House buildHouse(HouseBuilder builder) {
		House house = builder.createHouse();
		house.setFloor(builder.createFloor());
		house.setRoof(builder.createRoof());
		house.setWalls(builder.createWalls());
		return house;
	}
	
	public static void main(String...strings) {
		HouseDirector director = new HouseDirector();
		House woodHouse = director.buildHouse(new WoodHouseBuilder());
		House brickHouse = director.buildHouse(new BrickHouseBuilder());
		woodHouse.toString();
		brickHouse.toString();
	}

}
