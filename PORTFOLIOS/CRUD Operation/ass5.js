// Import necessary modules
const { MongoClient, ObjectId } = require('mongodb');

// MongoDB connection URI
const uri = 'mongodb://localhost:27017'; // Connect to the 'ass5' database

// Connect to MongoDB and initialize data
async function connectAndInitializeData() {
    try {
        await client.connect();
        console.log('Connected to MongoDB');

        // Insert customers
        const johnId = await insertCustomer({
            title: 'Mr',
            firstName: 'John',
            surname: 'Doe',
            mobile: '123456789',
            email: 'john@example.com',
            homeAddress: {
                addressLine1: '123 Main St',
                town: 'Anytown',
                countyCity: 'County',
                eircode: 'ABC123'
            },
            shippingAddress: {
                addressLine1: '456 Elm St',
                town: 'Othertown',
                countyCity: 'County',
                eircode: 'DEF456'
            }
        });

        const maryId = await insertCustomer({
            title: 'Ms',
            firstName: 'Mary',
            surname: 'Smith',
            mobile: '987654321',
            email: 'mary@example.com',
            homeAddress: {
                addressLine1: '789 Oak St',
                town: 'Sometown',
                countyCity: 'County',
                eircode: 'GHI789'
            },
            shippingAddress: {
                addressLine1: '321 Cedar St',
                town: 'Anothertown',
                countyCity: 'County',
                eircode: 'JKL321'
            }
        });

        const ashleyId = await insertCustomer({
            title: 'Ms',
            firstName: 'Ashley',
            surname: 'Johnson',
            mobile: '555123456',
            email: 'ashley@example.com',
            homeAddress: {
                addressLine1: '987 Pine St',
                town: 'Yetanothertown',
                countyCity: 'County',
                eircode: 'MNO987'
            },
            shippingAddress: {
                addressLine1: '654 Maple St',
                town: 'Finaltown',
                countyCity: 'County',
                eircode: 'PQR654'
            }
        });

        // Insert items
        const iphoneId = await insertItem({
            manufacturer: 'Apple',
            model: 'iPhone 12',
            price: 999
        });

        const samsungId = await insertItem({
            manufacturer: 'Samsung',
            model: 'Galaxy S21',
            price: 899
        });

        const googleId = await insertItem({
            manufacturer: 'Google',
            model: 'Pixel 5',
            price: 799
        });

        // Insert orders
        await insertOrder({
            customerId: ObjectId(johnId),
            items: [{ itemId: ObjectId(iphoneId), quantity: 1 }],
            totalPrice: 999
        });

        await insertOrder({
            customerId: ObjectId(maryId),
            items: [{ itemId: ObjectId(samsungId), quantity: 1 }],
            totalPrice: 899
        });

        await insertOrder({
            customerId: ObjectId(ashleyId),
            items: [{ itemId: ObjectId(googleId), quantity: 1 }],
            totalPrice: 799
        });
    } catch (err) {
        console.error('Error initializing data:', err);
    }
}

// CRUD operations for customers
async function insertCustomer(customerDetails) {
    try {
        const result = await client.db().collection('customer').insertOne(customerDetails);
        console.log('Customer created:', result.insertedId);
        return result.insertedId;
    } catch (err) {
        console.error('Error creating customer:', err);
    }
}

async function findCustomer(customerDetails) {
    try {
        const customer = await client.db().collection('customer').findOne(customerDetails);
        console.log('Customer details:', customer);
        return customer;
    } catch (err) {
        console.error('Error finding customer:', err);
    }
}

async function updateCustomer(filter, updatedData) {
    try {
        const result = await client.db().collection('customer').updateOne(filter, { $set: updatedData });
        console.log('Customer updated:', result.modifiedCount);
    } catch (err) {
        console.error('Error updating customer:', err);
    }
}

async function deleteCustomer(filter) {
    try {
        const result = await client.db().collection('customer').deleteMany(filter);
        console.log('Customer(s) deleted:', result.deletedCount);
    } catch (err) {
        console.error('Error deleting customer(s):', err);
    }
}

// CRUD operations for items
async function insertItem(itemDetails) {
    try {
        const result = await client.db().collection('item').insertOne(itemDetails);
        console.log('Item created:', result.insertedId);
        return result.insertedId;
    } catch (err) {
        console.error('Error creating item:', err);
    }
}

async function findItem(itemDetails) {
    try {
        const item = await client.db().collection('item').findOne(itemDetails);
        console.log('Item details:', item);
        return item;
    } catch (err) {
        console.error('Error finding item:', err);
    }
}

async function updateItem(filter, updatedData) {
    try {
        const result = await client.db().collection('item').updateOne(filter, { $set: updatedData });
        console.log('Item updated:', result.modifiedCount);
    } catch (err) {
        console.error('Error updating item:', err);
    }
}

async function deleteItem(filter) {
    try {
        const result = await client.db().collection('item').deleteMany(filter);
        console.log('Item(s) deleted:', result.deletedCount);
    } catch (err) {
        console.error('Error deleting item(s):', err);
    }
}

// CRUD operations for orders
async function insertOrder(orderDetails) {
    try {
        const result = await client.db().collection('order').insertOne(orderDetails);
        console.log('Order created:', result.insertedId);
        return result.insertedId;
    } catch (err) {
        console.error('Error creating order:', err);
    }
}

async function findOrder(orderDetails) {
    try {
        const order = await client.db().collection('order').findOne(orderDetails);
        console.log('Order details:', order);
        return order;
    } catch (err) {
        console.error('Error finding order:', err);
    }
}

async function updateOrder(filter, updatedData) {
    try {
        const result = await client.db().collection('order').updateOne(filter, { $set: updatedData });
        console.log('Order updated:', result.modifiedCount);
    } catch (err) {
        console.error('Error updating order:', err);
    }
}

async function deleteOrder(filter) {
    try {
        const result = await client.db().collection('order').deleteMany(filter);
        console.log('Order(s) deleted:', result.deletedCount);
    } catch (err) {
        console.error('Error deleting order(s):', err);
    }
}

// Export functions for use in other modules
module.exports = {
    connectAndInitializeData
};
