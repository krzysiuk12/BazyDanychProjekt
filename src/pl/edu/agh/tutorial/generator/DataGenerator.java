package pl.edu.agh.tutorial.generator;

import pl.edu.agh.data.*;
import pl.edu.agh.tutorial.domain.*;

import java.util.*;

/**
 * Created by Krzysiu on 2014-05-13.
 */
public class DataGenerator {

    private static final Random RANDOM = new Random();

    public List<Company> createCompanies(int numberOfCompanies) {
        List<Company> resultSet = new ArrayList<Company>();
        for(int index = 0; index < numberOfCompanies; index++) {
            Company company = new Company();
            company.setCompanyName(CustomersData.COMPANY_NAMES[RANDOM.nextInt(CustomersData.COMPANY_NAMES.length)]);
            company.setPhone(CustomersData.PHONES[RANDOM.nextInt(CustomersData.PHONES.length)]);
            Address address = new Address();
            address.setAddress(CustomersData.ADDRESSES[RANDOM.nextInt(CustomersData.ADDRESSES.length)]);
            address.setCity(CustomersData.CITIES[RANDOM.nextInt(CustomersData.CITIES.length)]);
            address.setRegion(CustomersData.REGIONS[RANDOM.nextInt(CustomersData.REGIONS.length)]);
            address.setPostalCode(CustomersData.POSTAL_CODES[RANDOM.nextInt(CustomersData.POSTAL_CODES.length)]);
            address.setCountry(CustomersData.COUNTRIES[RANDOM.nextInt(CustomersData.COUNTRIES.length)]);
            company.setAddress(address);
            resultSet.add(company);
        }
        return resultSet;
    }

    public List<Individual> createIndividuals(int numberOfIndividuals) {
        List<Individual> resultSet = new ArrayList<Individual>();
        for (int index = 0; index < numberOfIndividuals; index++) {
            Individual individual = new Individual();
            individual.setFirstName(index % 2 == 0 ? CustomersData.FIRSTNAMES_MEN[RANDOM.nextInt(CustomersData.FIRSTNAMES_MEN.length)] : CustomersData.FIRSTNAMES_WOMEN[RANDOM.nextInt(CustomersData.FIRSTNAMES_WOMEN.length)]);
            individual.setLastName(CustomersData.LASTNAMES[RANDOM.nextInt(CustomersData.LASTNAMES.length)]);
            Address address = new Address();
            address.setAddress(CustomersData.ADDRESSES[RANDOM.nextInt(CustomersData.ADDRESSES.length)]);
            address.setCity(CustomersData.CITIES[RANDOM.nextInt(CustomersData.CITIES.length)]);
            address.setRegion(CustomersData.REGIONS[RANDOM.nextInt(CustomersData.REGIONS.length)]);
            address.setPostalCode(CustomersData.POSTAL_CODES[RANDOM.nextInt(CustomersData.POSTAL_CODES.length)]);
            address.setCountry(CustomersData.COUNTRIES[RANDOM.nextInt(CustomersData.COUNTRIES.length)]);
            individual.setAddress(address);
            resultSet.add(individual);
        }
        return resultSet;
    }


    public List<Category> generateCategories(int numberOfCategories) {
        List<Category> categories = new ArrayList<Category>();
        for(int index = 0; index < numberOfCategories; index++) {
            Category category = new Category();
            category.setCategoryName(CategoryData.CATEGORY_NAMES[RANDOM.nextInt(CategoryData.CATEGORY_NAMES.length)]);
            category.setDescription(CategoryData.CATEGORY_DESCRIPTION[RANDOM.nextInt(CategoryData.CATEGORY_DESCRIPTION.length)]);
            categories.add(category);
        }
        return categories;
    }

    public List<Supplier> generateSuppliers(int numberOfSuppliers) {
        List<Supplier> suppliers = new ArrayList<Supplier>();
        for(int index = 0; index < numberOfSuppliers; index++) {
            Supplier supplier = new Supplier();
            supplier.setCompanyName(SuppliersData.SUPPLIERS_COMPANY_NAMES[RANDOM.nextInt(SuppliersData.SUPPLIERS_COMPANY_NAMES.length)]);
            supplier.setPhone(SuppliersData.SUPPLIERS_PHONES[RANDOM.nextInt(SuppliersData.SUPPLIERS_PHONES.length)]);
            Address address = new Address();
            address.setAddress(SuppliersData.SUPPLIERS_ADDRESSES[RANDOM.nextInt(SuppliersData.SUPPLIERS_ADDRESSES.length)]);
            address.setCity(SuppliersData.SUPPLIERS_CITIES[RANDOM.nextInt(SuppliersData.SUPPLIERS_CITIES.length)]);
            address.setCountry(SuppliersData.SUPPLIERS_COUNTRIES[RANDOM.nextInt(SuppliersData.SUPPLIERS_COUNTRIES.length)]);
            address.setRegion(SuppliersData.SUPPLIERS_REGIONS[RANDOM.nextInt(SuppliersData.SUPPLIERS_REGIONS.length)]);
            address.setPostalCode(SuppliersData.SUPPLIERS_POSTAL_CODES[RANDOM.nextInt(SuppliersData.SUPPLIERS_POSTAL_CODES.length)]);
            supplier.setAddress(address);
            suppliers.add(supplier);
        }
        return suppliers;
    }

    public List<Product> generateProducts(int numberOfProducts, List<Category> categories, List<Supplier> supplier) {
        List<Product> products = new ArrayList<Product>();
        for(int index = 0; index < numberOfProducts; index++) {
            Product product = new Product();
            product.setProductName(ProductsData.PRODUCT_NAMES[RANDOM.nextInt(ProductsData.PRODUCT_NAMES.length)]);
            product.setQuantityPerUnit(ProductsData.PRODUCT_QUANTITY_PER_UNIT[RANDOM.nextInt(ProductsData.PRODUCT_QUANTITY_PER_UNIT.length)]);
            product.setUnitPrice(ProductsData.PRODUCT_UNIT_PRICE[RANDOM.nextInt(ProductsData.PRODUCT_UNIT_PRICE.length)]);
            product.setUnitsInStock(ProductsData.PRODUCT_UNITS_IN_STOCK[RANDOM.nextInt(ProductsData.PRODUCT_UNITS_IN_STOCK.length)]);
            product.setDiscontinued(ProductsData.PRODUCT_DISCONTINUED[RANDOM.nextInt(ProductsData.PRODUCT_DISCONTINUED.length)]);
            product.setCategory(categories.get(RANDOM.nextInt(categories.size())));
            product.setSupplier(supplier.get(RANDOM.nextInt(supplier.size())));
            products.add(product);
        }
        return products;
    }

    public List<Order> createOrders(int numberOfOrders, List<Customer> customers, List<Product> products) {
        List<Order> orders = new ArrayList<Order>();
        for(int index = 0; index < numberOfOrders; index++) {
            Order order = new Order();
            order.setCustomer(customers.get(RANDOM.nextInt(customers.size())));
            order.setShipAddress(OrdersData.SHIP_ADDRESSES[RANDOM.nextInt(OrdersData.SHIP_ADDRESSES.length)]);
            order.setShipCity(OrdersData.SHIP_CITIES[RANDOM.nextInt(OrdersData.SHIP_CITIES.length)]);
            order.setShipRegion(OrdersData.SHIP_REGIONS[RANDOM.nextInt(OrdersData.SHIP_REGIONS.length)]);
            order.setShipPostalCode(OrdersData.SHIP_POSTAL_CODES[RANDOM.nextInt(OrdersData.SHIP_POSTAL_CODES.length)]);
            order.setShipCountry(OrdersData.SHIP_COUNTRIES[RANDOM.nextInt(OrdersData.SHIP_COUNTRIES.length)]);
            createOrderDetails(RANDOM.nextInt(15), products, order);
            createOrderDates(index % 3, order);
            orders.add(order);
        }
        return orders;
    }

    private void createOrderDetails(int numberOfPositions, List<Product> products, Order order) {
        Set<OrderDetail> details = new HashSet<OrderDetail>();
        for(int index = 0; index < numberOfPositions; index++) {
            OrderDetail detail = new OrderDetail();
            detail.setProduct(products.get(RANDOM.nextInt(products.size())));
            detail.setOrder(order);
            detail.setUnitPrice(detail.getProduct().getUnitPrice());
            detail.setDiscount(RANDOM.nextFloat());
            detail.setQuantity(RANDOM.nextInt(50));
            details.add(detail);
        }
        order.setOrderDetails(details);
    }

    private void createOrderDates(int type, Order order) {
        Calendar calendar = Calendar.getInstance();
        boolean calendarIsSet = false;
        switch(type) {
            case 2: //Shipped
                calendarIsSet = true;
                calendar.set(RANDOM.nextInt(3) + 2012, calendar.get(Calendar.MONTH), RANDOM.nextInt(calendar.get(Calendar.DAY_OF_MONTH)));
                order.setShippedDate(calendar.getTime());
            case 1: //Required
                if(calendarIsSet) {
                    calendar = (Calendar)calendar.clone();
                    calendar.add(Calendar.DAY_OF_MONTH, (RANDOM.nextInt(7) - 4));
                } else {
                    calendarIsSet = true;
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, RANDOM.nextInt(calendar.get(Calendar.DAY_OF_MONTH)));
                }
                order.setRequiredDate(calendar.getTime());
            case 0: //Ordered
                if(calendarIsSet) {
                    calendar = (Calendar)calendar.clone();
                    calendar.add(Calendar.DAY_OF_MONTH, -(RANDOM.nextInt(7) - 1));
                } else {
                    calendarIsSet = true;
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), RANDOM.nextInt(calendar.get(Calendar.DAY_OF_MONTH)));
                }
                order.setOrderDate(calendar.getTime());
        }
    }
}
