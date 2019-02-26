import { MonedaPipe } from './moneda.pipe';

describe('MonedaPipe', () => {
  it('create an instance', () => {
    const pipe = new MonedaPipe();
    expect(pipe).toBeTruthy();
  });
});
