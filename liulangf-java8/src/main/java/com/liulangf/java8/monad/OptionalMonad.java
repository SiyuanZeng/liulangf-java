package com.liulangf.java8.monad;

import java.util.Optional;

/**
 * Optional combines computations which may not return a result.
 * 
 * Optional<String> cityName = findUser(userId)
 *                             .flatMap(user -> user.getAddress())
 *                             .flatMap(address -> address.getZipCode())
 *                             .flatMap(zipCode -> findCityByZipCode(zipCode))
 *                             .map(city -> city.getName());
 * 
 * 
 * <pre>
 *   User user = findUser(userId);
 *   if (user != null) {
 *       Address address = user.getAddress();
 *       if (address != null) {
 *           String zipCode = address.getZipCode();
 *           if (zipCode != null) {
 *               City city = findCityByZipCode(zipCode);
 *               if (city != null) {
 *                   return city.getName();
 *               }
 *           }
 *       }
 *   }
 * </pre>
 *
 */
public class OptionalMonad {
	
	public void optional() {
		Optional.of("hello").flatMap(s -> Optional.of("ss"));
	}

}
